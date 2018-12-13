package liuyu.flink

import java.text.SimpleDateFormat

import org.apache.flink.streaming.api.TimeCharacteristic
import org.apache.flink.streaming.api.functions.AssignerWithPeriodicWatermarks
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.watermark.Watermark
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.streaming.api.windowing.windows.TimeWindow
import org.apache.flink.util.Collector
import org.apache.flink.streaming.api.scala.function.WindowFunction

/**
  * ClassName: WatermarkAndWindowTest <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-8-28 下午5:35 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object WatermarkAndWindowTest {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime)
    env.setParallelism(1)


    val input = env.socketTextStream("127.0.0.1", 6666)

    val inputMap = input.map(f => {
      val arr = f.split("\\W+")
      val code = arr(0)
      val time = arr(1).toLong
      (code, time)
    })

    val watermark = inputMap.assignTimestampsAndWatermarks(new AssignerWithPeriodicWatermarks[(String, Long)] {

      var currentMaxTimestamp = 0L
      val maxOutOfOrderness = 20000L //最大允许的乱序时间是10s

      var a: Watermark = null

      val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")

      override def getCurrentWatermark: Watermark = {
        a = new Watermark(currentMaxTimestamp - maxOutOfOrderness)
        //        println("dddd:"+currentMaxTimestamp)
        a
      }

      override def extractTimestamp(t: (String, Long), l: Long): Long = {
        val timestamp = t._2
        currentMaxTimestamp = Math.max(timestamp, currentMaxTimestamp)

        println("timestamp:" + t._1 + ",输入时间：" + t._2 + "|" + format.format(t._2) +
          ",当前时间" + currentMaxTimestamp + "|" + format.format(currentMaxTimestamp) +
          ",watermark:" + a.toString + "|" + format.format(a.getTimestamp))
        timestamp
      }
    })

    val window = watermark
      .keyBy(_._1)
      .window(TumblingEventTimeWindows.of(Time.seconds(10)))
      .apply(new WindowFunctionTest)


    window.print()

    env.execute()

  }

  class WindowFunctionTest extends WindowFunction[(String, Long), (String, Int, String, String, String, String), String, TimeWindow] {

    override def apply(key: String, window: TimeWindow, input: Iterable[(String, Long)], out: Collector[(String, Int, String, String, String, String)]): Unit = {
      val list = input.toList.sortBy(_._2)
      val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
      out.collect(key, input.size, "数据结束时间：" + format.format(list.head._2), "数据结束时间：" + format.format(list.last._2), "window开始时间：" + format.format(window.getStart), "window结束时间：" + format.format(window.getEnd))
    }

  }

}

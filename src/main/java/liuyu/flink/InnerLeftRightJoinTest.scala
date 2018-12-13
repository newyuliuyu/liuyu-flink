package liuyu.flink

import java.lang
import java.text.SimpleDateFormat

import org.apache.flink.api.common.functions.CoGroupFunction
import org.apache.flink.api.scala.ExecutionEnvironment
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.util.Collector
import java.util.Date

import org.apache.flink.streaming.api.TimeCharacteristic

/**
  * ClassName: InnerLeftRightJoinTest <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-8-24 上午11:27 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object InnerLeftRightJoinTest {


  def main(args: Array[String]): Unit = {
    val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime)
    //    val env = ExecutionEnvironment.getExecutionEnvironment
        var myfiledata1 = env.readTextFile("/home/liuyu/workeidea/liuyu-flink/src/main/resources/data1.csv")
        var myfiledata2 = env.readTextFile("/home/liuyu/workeidea/liuyu-flink/src/main/resources/data2.csv")
//    val myfiledata1 = env.socketTextStream("127.0.0.1", 9998)
//    val myfiledata2 = env.socketTextStream("127.0.0.1", 9999)

    var mydata1 = myfiledata1.map(f => {
      val tokens1 = f.split(",")
      StockTransaction(tokens1(0), tokens1(1), tokens1(2).toDouble)
    })
      .assignAscendingTimestamps(f => {
        var time = format.parse(f.tx_time).getTime
        time
        //        println("1:"+time)
        //        new Date().getTime
      })
    //    mydata1.print()

    var mydata2 = myfiledata2.map(f => {
      val tokens1 = f.split(",")
//      println(tokens1)
      StockSnapshot(tokens1(0), tokens1(1), tokens1(2).toDouble)
    })
      .assignAscendingTimestamps(f => {
        var time = format.parse(f.md_time).getTime
        time
        //        println("2:"+time)
        //          new Date().getTime
      })
    //  mydata2.print()

    val joinedStream = mydata1
      .coGroup(mydata2)
      .where(_.tx_code)
      .equalTo(_.md_code)
      .window(TumblingEventTimeWindows.of(Time.seconds(3)))


    val innerJoinedStream = joinedStream.apply(new InnerJoinFunction)
    innerJoinedStream.name("InnerJoinedStream").print()
    env.execute("dddd")
  }

  case class StockTransaction(tx_time: String, tx_code: String, tx_value: Double)

  case class StockSnapshot(md_time: String, md_code: String, md_value: Double)

  class InnerJoinFunction extends CoGroupFunction[StockTransaction, StockSnapshot, (String, String, String, Double, Double, String)] {
    override def coGroup(first: lang.Iterable[StockTransaction], second: lang.Iterable[StockSnapshot], out: Collector[(String, String, String, Double, Double, String)]): Unit = {
      println("**********************")
      import scala.collection.JavaConverters._
      val scalaT1 = first.asScala.toList
      val scalaT2 = second.asScala.toList
      if (scalaT1.nonEmpty && scalaT2.nonEmpty) {
        for (transaction <- scalaT1) {
          for (snapshot <- scalaT2) {
            out.collect(transaction.tx_code, transaction.tx_time, snapshot.md_time, transaction.tx_value, snapshot.md_value, "Inner Join Test")
          }
        }
      }
    }
  }

}

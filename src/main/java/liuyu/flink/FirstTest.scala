package liuyu.flink


import org.apache.flink.api.scala.{DataSet, ExecutionEnvironment}
import org.apache.flink.streaming.api.scala._


/**
  * ClassName: MyTest <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-8-23 上午11:21 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object FirstTest {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
//    val env2 = ExecutionEnvironment.getExecutionEnvironment
//
//    val tuples: DataSet[Int] = env2.fromElements(1, 2)


    var text = env.fromElements("hadoop hive?", "think hadoop hive sqoop hbase spark flink?")
    val counts: DataStream[(String, Int)] = text
      .flatMap(_.toLowerCase.split("\\W+"))
      .filter(_.nonEmpty)
      .map((_, 1))
      .keyBy(0)
      .sum(1)
    counts.print()
    env.execute("Streaming WordCount")

  }
}

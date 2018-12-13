package liuyu.flink

import org.apache.flink.api.scala._
import org.apache.flink.table.api.TableEnvironment
import org.apache.flink.table.api.scala._
/**
  * ClassName: TableAndSQLTest <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-8-28 下午2:10 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object TableAndSQLTest {

  case class WC(word: String, frequency: Long)

  def main(args: Array[String]): Unit = {
    // ***************
    // STREAMING QUERY
    // ***************
    //    val sEnv = StreamExecutionEnvironment.getExecutionEnvironment
    //    // create a TableEnvironment for streaming queries
    //    val sTableEnv = TableEnvironment.getTableEnvironment(sEnv)

    // ***********
    // BATCH QUERY
    // ***********
    val bEnv = ExecutionEnvironment.getExecutionEnvironment
    // create a TableEnvironment for batch queries
    val bTableEnv = TableEnvironment.getTableEnvironment(bEnv)


    val input = bEnv.fromElements(WC("hello", 1), WC("hello", 1), WC("ciao", 1))

    //模式1
    val expr = input.toTable(bTableEnv)
    val result = expr
      .groupBy('word)
      .select('word, 'frequency.sum as 'frequency)
      .filter('frequency === 2)

    var explan  = bTableEnv.explain(result)
    println(explan)
    //result.toDataSet[WC].print()

    //模式2 结果与模式1相同
//    bTableEnv.registerDataSet("mytable",input)
//    val result = bTableEnv.sqlQuery("select word,SUM(frequency) as frequency from mytable group by word having SUM(frequency)=2")
//    result.toDataSet[WC].print()
  }


}

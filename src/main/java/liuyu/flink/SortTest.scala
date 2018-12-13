package liuyu.flink

import org.apache.flink.api.scala._
import org.apache.flink.api.common.operators.Order
import org.apache.flink.util.Collector

/**
  * ClassName: SortTest <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-8-28 上午10:19 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object SortTest {
  def main(args: Array[String]): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    var dataset = env.fromElements((2, 1), (2, 3), (2, 2), (1, 1), (1, 3), (1, 2), (4, 1), (4, 3), (4, 2), (3, 1), (3, 3), (3, 2))
        var sortDataset = dataset.sortPartition(1, Order.DESCENDING)
//        sortDataset.print()
        var dataset2 = sortDataset.groupBy(0).combineGroup((it, out: Collector[(Int, Int)]) => {
          var sum = 0
          var key = 0
          for (values <- it) {
            key = values._1
            sum += values._2
            println(values)
          }
          out.collect((key, sum))
        })
//    var dataset2 = dataset.groupBy(0).reduceGroup {
//      (it, out: Collector[(Int, Int)]) =>
//        var sum = 0
//        var key = 0
//        for (values <- it) {
//          key = values._1
//          sum += values._2
//        }
//        out.collect((key, sum))
//    }

//    var dataset2 = dataset.groupBy(0).reduce{
//      (v1,v2) =>
//        (v1._1,v1._2+v2._2)
//    }

    dataset2.print()
  }
}

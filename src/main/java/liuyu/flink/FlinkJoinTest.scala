package liuyu.flink

import org.apache.flink.api.scala._
import org.apache.flink.util.Collector

/**
  * ClassName: FlinkJoinTest <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-8-27 下午5:57 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object FlinkJoinTest {
  def main(args: Array[String]): Unit = {

    val env = ExecutionEnvironment.getExecutionEnvironment


    var verticesAsWorkset = generateWorksetWithVertices(env)
    var edges = generateDefaultEdgeDataSet(env)

    val deltas = verticesAsWorkset.join(edges).where(0).equalTo(0) {
      (lastDeltas, adj, out: Collector[(Int, Int)]) => {
        out.collect((lastDeltas._1, adj._1))
      }
    }
    deltas.print()
  }

  def generateWorksetWithVertices(env: ExecutionEnvironment): DataSet[(Int, Int)] = {
    var list: List[(Int, Int)] = List();
    for (i <- 1 to 15) {
      list = list :+ ((i, i))
    }
    var dataset = env.fromCollection(list)
    return dataset;
  }

  def generateDefaultEdgeDataSet(env: ExecutionEnvironment): DataSet[(Int, Int)] = {
    var dataset = env.fromElements((1, 2), (2, 3), (2, 4), (4, 5), (6, 7), (5, 8), (9, 10), (9, 11), (8, 12), (10, 13), (1, 14), (11, 15))
    return dataset;
  }
}

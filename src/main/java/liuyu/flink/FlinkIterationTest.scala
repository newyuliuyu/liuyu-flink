package liuyu.flink

import org.apache.flink.api.scala.{DataSet, ExecutionEnvironment}
import org.apache.flink.streaming.api.scala._

/**
  * ClassName: FlinkIterationTest <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-8-27 下午1:57 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object FlinkIterationTest {
  def main(args: Array[String]): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    var someIntegers: DataSet[Int] = env.fromElements(0)


    //    var count = someIntegers.iterate(1000)(
    //      data => {
    //        val result = data.map(i => {
    //          var x = Math.random()
    //          var y = Math.random()
    //          var b = if (x * x + y * y < 1) 1 else 0
    //          return i + b
    //        })
    //        return result
    //      }
    //    )
    var count = someIntegers.iterate(1000) {
      iterationInput =>
        val result = iterationInput.map { i =>
          val x = Math.random()
          val y = Math.random()
          i + (if (x * x + y * y < 1) 1 else 0)
        }
        result
    }
    val result = count.map(a => {
      a / 10000d * 4
    })
    //    someIntegers.print()
    result.print()
//    env.execute("dddd")
  }
}

package liuyu.flink

import org.apache.flink.streaming.api.scala._

/**
  * ClassName: StreamIterationTest <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-8-28 上午10:00 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object StreamIterationTest {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val someIntegers: DataStream[Long] = env.generateSequence(0, 10)

    val iteratedStream = someIntegers.iterate(
      iteration => {
        val minusOne = iteration.map( v => v - 1)
        val stillGreaterThanZero = minusOne.filter (_ > 0)
        val lessThanZero = minusOne.filter(_ <= 5)
        (stillGreaterThanZero, lessThanZero)
      }
    )
    iteratedStream.print()
    env.execute()
  }

}

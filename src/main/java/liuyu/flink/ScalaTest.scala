package liuyu.flink

import java.text.SimpleDateFormat

/**
  * ClassName: ScalaTest <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-8-27 下午5:17 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object ScalaTest {
  def main(args: Array[String]): Unit = {
    var list:List[Int] = List(1)
    list.::(0)
    list.::(1)
    list.::(2)

    val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
    var k  = format.format(-20000L)
    println(k)

  }

}

package liuyu.simhash2

import org.junit.Test

/**
  * ClassName: MyTest <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-9-5 上午9:36 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
class MyTest {

  @Test
  def test01() = {
    var v  = java.lang.Long.parseLong("7fff000000000000", 16)
    println(v)
    println(v.toBinaryString)
    println(v.toBinaryString.length)

  }
}

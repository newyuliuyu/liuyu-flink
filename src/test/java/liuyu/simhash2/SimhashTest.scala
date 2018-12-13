package liuyu.simhash2

import org.junit.Test

/**
  * ClassName: SimhashTest <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-9-4 下午1:28 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
class SimhashTest {
  @Test
  def test02(): Unit = {
    println(Integer.parseInt("55555555", 16))
  }

  @Test
  def test01(): Unit = {
    val s1 = "This is a test string for testing"
    val s2 = "This is a test string for testing also"
    val s3 = "This is a test string for testing als"
    var simhash = new Simhash(4, 3)
    var simhashVal: Long = simhash.calSimhash(s1);
    println(simhashVal.toBinaryString)
    simhash.store(simhashVal, s1)

    var simhashVal2: Long = simhash.calSimhash(s2);
    simhash.store(simhashVal2, s2)
    println(simhashVal2.toBinaryString)

    println(simhash.hamming(simhashVal2, simhashVal))
    println(simhash.hamming2(simhashVal2, simhashVal))

    //
    //    simhashVal = simhash.calSimhash(s3);
    //    simhash.store(simhashVal, s3)
    //    println(simhashVal.toBinaryString)


    println(simhash.isDuplicate(s2))


  }

}

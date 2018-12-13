package liuyu.nlp

import org.ansj.splitWord.analysis._

/**
  * ClassName: BaseAnalysisDemo <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-9-3 下午5:32 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object BaseAnalysisDemo {

  def main(args: Array[String]): Unit = {
    var text = "我爱楚离陌"
    text = "让战士们过一个欢乐祥和的新春佳节。"
    println(BaseAnalysis.parse(text))
    println(ToAnalysis.parse(text))
    println(DicAnalysis.parse(text))
    println(IndexAnalysis.parse(text))
    println(NlpAnalysis.parse(text))


    val str = "洁面仪配合洁面深层清洁毛孔 清洁鼻孔面膜碎觉使劲挤才能出一点点皱纹 脸颊毛孔修复的看不见啦 草莓鼻历史遗留问题没辙 脸和脖子差不多颜色的皮肤才是健康的 长期使用安全健康的比同龄人显小五到十岁 28岁的妹子看看你们的鱼尾纹"

    println(BaseAnalysis.parse(str))
    println(ToAnalysis.parse(str))
    println(DicAnalysis.parse(str))
    println(IndexAnalysis.parse(str))
    println(NlpAnalysis.parse(str))
  }
}

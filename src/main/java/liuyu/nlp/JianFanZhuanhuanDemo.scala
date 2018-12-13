package liuyu.nlp

/**
  * ClassName: JianFanZhuanhuanDemo <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-9-6 上午10:36 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object JianFanZhuanhuanDemo {
  def main(args: Array[String]): Unit = {
    import org.ansj.domain.Result
    import org.ansj.splitWord.analysis.DicAnalysis
    import org.ansj.util.MyStaticValue
    import org.nlpcn.commons.lang.jianfan.JianFan
    import java.util
    MyStaticValue.isRealName = true
    val all = new util.ArrayList[String]
    all.add("關注十八大：台港澳密集解讀十八大報告”")
    all.add("关注十八大：台港澳密集解读十八大报告”")
    all.add("參選國民黨主席？ 胡志強首度鬆口稱“會考慮”")
    all.add("参选国民党主席？ 胡志强首度鬆口称“会考虑”")
    all.add("駁謝長廷“國民黨像東廠” 藍營吁其勿惡意嘲諷")
    all.add("驳谢长廷“国民党像东厂” 蓝营吁其勿恶意嘲讽")
    all.add("台藝人陳俊生出軌逼死女友 絕情獸行遭曝光")
    all.add("台艺人陈俊生出轨逼死女友 绝情兽行遭曝光")
    all.add("林益世想回高雄探母 法官警告勿有逃亡念頭")
    all.add("林益世想回高雄探母 法官警告勿有逃亡念头")
    all.add("吳伯雄談建言被誤解讀:盡點言責 絕對善意")
    all.add("輸入簡體字,點下面繁體字按鈕進行在線轉換.")
    import scala.collection.JavaConversions._
    for (string <- all) {
      val parse = DicAnalysis.parse(JianFan.f2j(string))
      System.out.println(parse)
    }
  }
}

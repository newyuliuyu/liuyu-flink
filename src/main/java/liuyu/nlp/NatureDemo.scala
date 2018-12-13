package liuyu.nlp

/**
  * ClassName: NatureDemo <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-9-6 上午10:49 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object NatureDemo {
  def main(args: Array[String]): Unit = {
    import org.ansj.domain.Result
    import org.ansj.recognition.impl.NatureRecognition
    import org.ansj.splitWord.analysis.ToAnalysis
    val terms = ToAnalysis.parse("Ansj中文分词是一个真正的ict的实现.并且加入了自己的一些数据结构和算法的分词.实现了高效率和高准确率的完美结合!")
    terms.recognition(new NatureRecognition) //词性标注

    System.out.println(terms)

  }
}

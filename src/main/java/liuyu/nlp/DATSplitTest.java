package liuyu.nlp;

import org.ansj.splitWord.impl.GetWordsImpl;

/**
 * ClassName: DATSplitTest <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date: 18-9-6 上午11:16 <br/>
 *
 * @author liuyu
 * @version v1.0
 * @since JDK 1.7+
 */
public class DATSplitTest {
    public static void main(String[] args) {
        GetWordsImpl gwi = new GetWordsImpl();
        gwi.setStr("程序员祝海林和朱会震是在孙健的左面和右面.范凯在最右面.再往左是李松洪");
        String temp = null ;
        while((temp = gwi.allWords())!=null){
            System.out.println(temp);
        }
    }
}

package liuyu.nlp;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.library.StopLibrary;
import org.ansj.recognition.impl.StopRecognition;
import org.ansj.splitWord.analysis.ToAnalysis;

/**
 * ClassName: FilterRecognitionTest <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date: 18-9-6 下午1:21 <br/>
 *
 * @author liuyu
 * @version v1.0
 * @since JDK 1.7+
 */
public class FilterRecognitionTest {
    public static void main(String[] args){
        test();
        stopTest();
    }

    public static void test() {
        String str = "我的小鸡鸡丢了!";

        Result parse = ToAnalysis.parse(str);

        System.out.println(parse);

        StopRecognition fitler = new StopRecognition();

        fitler.insertStopNatures("uj");
        fitler.insertStopNatures("ul");
        fitler.insertStopNatures("null");

        fitler.insertStopWords("我");

        fitler.insertStopRegexes("小.*?");

        Result modifResult = parse.recognition(fitler);

        for (Term term : modifResult) {
            System.out.println(term);
        }

        System.out.println(modifResult);
    }


    public static void stopTest(){
        StopLibrary.insertStopWords(StopLibrary.DEFAULT, "的", "呵呵", "哈哈", "噢", "啊");
        Result terms = ToAnalysis.parse("英文版是小田亲自翻译的");
        //使用停用词
        System.out.println(terms.recognition(StopLibrary.get()));
    }
}

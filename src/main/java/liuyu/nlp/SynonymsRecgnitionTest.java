package liuyu.nlp;

import org.ansj.domain.Term;
import org.ansj.library.SynonymsLibrary;
import org.ansj.recognition.impl.SynonymsRecgnition;
import org.ansj.splitWord.analysis.ToAnalysis;

/**
 * ClassName: SynonymsRecgnitionTest <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date: 18-9-6 下午1:28 <br/>
 *
 * @author liuyu
 * @version v1.0
 * @since JDK 1.7+
 */
public class SynonymsRecgnitionTest {

    public static void main(String[] args) {

        //使用默认的同义词词典
        SynonymsRecgnition synonymsRecgnition = new SynonymsRecgnition();

        String str = "我国中国就是华夏,也是天朝";

        for (Term term : ToAnalysis.parse("我国中国就是华夏")) {
            System.out.println(term.getName() + "\t" + (term.getSynonyms()));
        }

        System.out.println("-------------init library------------------");

        for (Term term : ToAnalysis.parse(str).recognition(synonymsRecgnition)) {
            System.out.println(term.getName() + "\t" + (term.getSynonyms()));
        }

        System.out.println("---------------insert----------------");
        SynonymsLibrary.insert(SynonymsLibrary.DEFAULT, new String[]{"中国", "我国"});

        for (Term term : ToAnalysis.parse(str).recognition(synonymsRecgnition)) {
            System.out.println(term.getName() + "\t" + (term.getSynonyms()));
        }

        System.out.println("---------------append----------------");
        SynonymsLibrary.append(SynonymsLibrary.DEFAULT, new String[]{"中国", "华夏", "天朝"});

        for (Term term : ToAnalysis.parse(str).recognition(synonymsRecgnition)) {
            System.out.println(term.getName() + "\t" + (term.getSynonyms()));
        }

        System.out.println("---------------remove----------------");
        SynonymsLibrary.remove(SynonymsLibrary.DEFAULT, "我国");

        for (Term term : ToAnalysis.parse(str).recognition(synonymsRecgnition)) {
            System.out.println(term.getName() + "\t" + (term.getSynonyms()));
        }

    }
}

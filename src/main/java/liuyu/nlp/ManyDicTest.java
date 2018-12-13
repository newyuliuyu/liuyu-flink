package liuyu.nlp;

import org.ansj.library.DicLibrary;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.nlpcn.commons.lang.tire.domain.Forest;

/**
 * ClassName: ManyDicTest <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date: 18-9-6 上午11:21 <br/>
 *
 * @author liuyu
 * @version v1.0
 * @since JDK 1.7+
 */
public class ManyDicTest {
    public static void main(String[] args){
        Forest f1 = new Forest();
        f1.addBranch("ansj你好", new String[] { "f1", "1000" });

        Forest f2 = new Forest();
        f2.addBranch("ansj你不好", new String[] { "f2", "1000" });

        Forest f3 = new Forest();
        f3.addBranch("ansj你很好", new String[] { "f3", "1000" });

        String content = "ansj你好ansj你不好ansj你很好";

        System.out.println(ToAnalysis.parse(content, DicLibrary.get(), f1, f2));

        System.out.println(ToAnalysis.parse(content, f3, f2));
    }
}

package liuyu.nlp;

/**
 * ClassName: NatureTagDemo <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date: 18-9-6 上午10:54 <br/>
 *
 * @author liuyu
 * @version v1.0
 * @since JDK 1.7+
 */

import org.ansj.domain.Term;
import org.ansj.recognition.impl.NatureRecognition;

import java.util.Arrays;
import java.util.List;

/**
 * 对非ansj的分词结果进行词性标注
 *
 * @author ansj
 */
public class NatureTagDemo {
    public static void main(String[] args) {
        String[] strs = {"对", "非", "ansj", "的", "分词", "结果", "进行", "词性", "标注"};

        List<String> lists = Arrays.asList(strs);
        List<Term> recognition = new NatureRecognition().recognition(lists, 0);
        System.out.println(recognition);
    }
}
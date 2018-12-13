package liuyu.nlp;

/**
 * ClassName: RealWordDemo <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date: 18-9-6 上午11:07 <br/>
 *
 * @author liuyu
 * @version v1.0
 * @since JDK 1.7+
 */

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.ansj.util.MyStaticValue;

/**
 * 保持单词的大小写
 *
 * @author ansj
 */
public class RealWordDemo {
    public static void main(String[] args) {
        // 默认方式
        Result parse = ToAnalysis.parse("Hello word是每个程序员必经之路");
        System.out.println(parse);

        // 保证方式
        MyStaticValue.isRealName = true;
        parse = ToAnalysis.parse("Hello Word是每个程序员必经之路");
        for (Term term : parse) {
            System.out.print(term.getRealName() + " ");
        }
    }
}

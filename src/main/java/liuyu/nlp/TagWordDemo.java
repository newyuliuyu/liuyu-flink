package liuyu.nlp;

import org.ansj.app.keyword.Keyword;
import org.ansj.app.summary.TagContent;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: TagWordDemo <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date: 18-9-6 上午11:13 <br/>
 *
 * @author liuyu
 * @version v1.0
 * @since JDK 1.7+
 */
public class TagWordDemo {
    public static void main(String[] args) {
        TagContent tw = new TagContent("<begin>", "<end>");
        String content = "台湾两岸共同市场基金会代表团12312   不断推动两岸关";
        List<Keyword> keyWords = new ArrayList<Keyword>();
        keyWords.add(new Keyword("两岸关系",1.0));
        keyWords.add(new Keyword("两岸",1.0));
        keyWords.add(new Keyword("李克强",1.0));
        keyWords.add(new Keyword("博鳌",1.0));
        keyWords.add(new Keyword("12",1.0));
        System.out.println(tw.tagContent(keyWords, content));;
    }
}

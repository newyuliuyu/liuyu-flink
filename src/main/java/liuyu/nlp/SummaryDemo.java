package liuyu.nlp;

import org.ansj.app.summary.SummaryComputer;
import org.ansj.app.summary.TagContent;
import org.ansj.app.summary.pojo.Summary;

/**
 * ClassName: SummaryDemo <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date: 18-9-6 上午11:11 <br/>
 *
 * @author liuyu
 * @version v1.0
 * @since JDK 1.7+
 */
public class SummaryDemo {

    public static void main(String[] args) {

        String content = "4月1日，中共中央政治局常委、国务院副总理李克强在海南省博鳌会见前来出席博鳌亚洲论坛2012年年会的台湾两岸共同市场基金会代表团名誉团长吴敦义一行。新华社记者 饶爱民 摄        新华社海南博鳌４月１日电（记者李寒芳、周正平）中共中央政治局常委、国务院副总理李克强１日上午在海南省博鳌会见了前来出席博鳌亚洲论坛２０１２年年会的台湾两岸共同市场基金会代表团名誉团长吴敦义一行，表示同胞相见，朋友相识，都是令人愉悦的事。他强调，当前两岸关系又迎来发展的新机遇，面临着继往开来的新形势。希望两岸各界进一步携手合作，增进相互信任，厚植共同利益，融洽同胞感情，不断推动两岸关系向前迈进。两岸双方应共同努力，促进两岸经济合作在新的起点上开拓创新，更好地适应两岸经济发展的要求，更多地让两岸广大民众共享和平发展成果。    李克强表示，不久前胡锦涛总书记会见中国国民党荣誉主席吴伯雄时，全面阐述了我们在新形势下持续推动两岸关系发展的基本思路。我们将巩固反对“台独”、认同“九二共识”的共同政治基础，继续贯彻推动两岸关系和平发展的各项方针政策，不断开创两岸关系和平发展的新局面。    李克强强调，两岸同胞同属中华民族，两岸经济同属中华民族经济。进一步深化两岸经济合作，有利于促进两岸共同发展、造福两岸同胞。一是抓紧推动ＥＣＦＡ后续协商，力争尽早签署两岸投资保护和促进协议，推动其它商谈取得实质性进展。二是加快推进两岸金融领域合作。采取积极措施，尽快启动商议建立两岸货币清算机制，推进两岸银行、证券、保险业建立并完善监管合作机制。三是大力加强两岸产业合作，共同推动产业结构优化升级。我们鼓励和支持有条件的大陆企业赴台投资，期望台湾方面为此提供必要的环境和公平的条件。    李克强表示，我们将继续支持大陆台资企业的发展，更加注重协助他们在大陆转方式、调结构中更好地拓展大陆内需市场。对台资企业一视同仁，重视维护好他们的正当权益，及时解决他们遇到的问题。我们会在两岸关系改善发展的进程中，继续面向包括中小企业和农渔业者在内的台湾基层民众，多了解他们的愿望，多为他们办实事，使更多的台湾民众从中受益。    李克强指出，两岸还应继续推动其他领域的交流合作。我们欢迎并支持年内新增１０个大陆居民赴台个人旅游试点城市，这将有利于增进两岸同胞相互了解，促进台湾旅游业发展。    吴敦义表示，过去四年两岸关系走上了和平稳定发展的正确道路，台湾局势摆脱了动荡，两岸在“九二共识”基础上的协商迄今达成１６项协议，两岸经济在全球经济不景气的形势下实现了稳步发展。两岸关系和平发展的局面值得共同珍惜和巩固。他对这次会见双方就加快ＥＣＦＡ后续协商、建立两岸货币清算机制等一系列合作事项达成一致感到高兴，期望双方秉持求同存异、两岸和平、讲信修睦、民生优先的理念，进一步扩大交流，务实协商，加强合作，为两岸人民谋福祉，为中华民族谋繁荣，为炎黄子孙开盛世。";

        String title = "李克强在博鳌会见台湾两岸共同市场基金会代表团";

        SummaryComputer summaryComputer = new SummaryComputer(300, title, content);

        Summary summary = summaryComputer.toSummary();

        System.out.println(summary.getKeyWords()); // 关键词

        System.out.println(summary.getSummary()); // 摘要

        TagContent tw = new TagContent("<begin>", "<end>");

        String tagContent = tw.tagContent(summary); // 标记后的摘要

        System.out.println(tagContent);

    }
}
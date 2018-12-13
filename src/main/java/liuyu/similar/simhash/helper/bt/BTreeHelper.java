package liuyu.similar.simhash.helper.bt;

/**
 * ClassName: BTreeHelper <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date: 18-9-4 下午5:27 <br/>
 *
 * @author liuyu
 * @version v1.0
 * @since JDK 1.7+
 */

import liuyu.similar.simbash.support.NodeBuilderAdapter;
import liuyu.similar.simbash.support.bt.BTreeBulder;

import java.math.BigInteger;
import java.util.List;


public final class BTreeHelper {
    /**
     * 建造二叉排序树
     *
     * @param simHashList
     * @return
     */
    public static BTreeBulder build(List<BigInteger> simHashList) {
        if (simHashList == null || simHashList.isEmpty()) {
            return null;
        }
        BTreeBulder bTreeBulder = new BTreeBulder(simHashList);
        NodeBuilderAdapter nodeBuilderAdapter = new NodeBuilderAdapter();
        nodeBuilderAdapter.build(bTreeBulder);
        return bTreeBulder;
    }
}

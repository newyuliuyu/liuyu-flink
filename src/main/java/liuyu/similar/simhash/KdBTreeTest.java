package liuyu.similar.simhash;

import liuyu.similar.simbash.support.NodeBuilderAdapter;
import liuyu.similar.simbash.support.bt.BTreeBulder;
import liuyu.similar.simbash.support.bt.BTreeNode;
import liuyu.similar.simbash.support.bt.KdBTree;
import liuyu.similar.simhash.helper.bt.BTreeHelper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: KdBTreeTest <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date: 18-9-4 下午5:41 <br/>
 *
 * @author liuyu
 * @version v1.0
 * @since JDK 1.7+
 */
public class KdBTreeTest {
    public static void main(String[] args) {
        List<BigInteger> list = new ArrayList<>();
        for (long i = 1; i < 9; i++) {
            list.add(new BigInteger(i + ""));
            list.add(new BigInteger((i * 2) + ""));
        }
        list.add(new BigInteger("2302916563077"));
        BTreeHelper.build(list);

        //methodBigInteger();
    }

    private static void methodBigInteger() {
        List<BigInteger> list = new ArrayList<>();

        long st = System.currentTimeMillis();
        for (long i = 1; i < 9; i++) {
            list.add(new BigInteger(i + ""));
            list.add(new BigInteger((i * 2) + ""));
        }
        list.add(new BigInteger("2302916563077"));

        long st1 = System.currentTimeMillis();
        System.out.println("准备数据耗时：" + (st1 - st));
        BTreeBulder bTreeBulder = new BTreeBulder(list);
        NodeBuilderAdapter nodeBuilderAdapter = new NodeBuilderAdapter();
        nodeBuilderAdapter.build(bTreeBulder);
        long st2 = System.currentTimeMillis();
        System.out.println("建立排序二叉树耗时：" + (st2 - st1));
        KdBTree kdBTree = bTreeBulder.getbTree();
        BTreeNode node = kdBTree.queryBykey(new BigInteger("1000000000000000"));//kdBTree.queryBykey(new BigInteger("2577794470021"));
        long st3 = System.currentTimeMillis();
        System.out.println("查询耗时：" + (st3 - st2));
        System.out.println(node == null ? "null" : (node.getId() + "--" + node.getSubKey()));
    }
}
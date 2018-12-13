package liuyu.similar.simbash.support.bt;

import liuyu.similar.simbash.support.AbstractNode;

import java.math.BigInteger;

/**
 * ClassName: BTree <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date: 18-9-4 下午5:32 <br/>
 *
 * @author liuyu
 * @version v1.0
 * @since JDK 1.7+
 */
public interface BTree<T extends Number> {
    /**
     * 增加节点
     * @param key
     */
    public abstract long add(long key);
    /**
     * 删除节点，有问题，不能用
     * @param nodeId
     */
    public abstract boolean delete(long nodeId);
    /**
     * 更新节点，有问题，不能用
     * @param nodeId
     * @param subKey
     */
    public abstract boolean update(long nodeId,long subKey);
    /**
     * 查询，只返回当前节点信息，不包含父节点和子节点信息
     * @param key
     * @return
     */
    public abstract AbstractNode queryBykey(BigInteger key);
    /**
     * 查询，使用会有问题，应用可能会占用大量内存
     * @param nodeId
     * @return
     */
    public abstract AbstractNode queryByNodeId(long nodeId);
}
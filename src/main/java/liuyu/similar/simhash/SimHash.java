package liuyu.similar.simhash;

import liuyu.similar.Similar;

import java.util.List;

/**
 * ClassName: SimHash <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date: 18-9-4 下午5:36 <br/>
 *
 * @author liuyu
 * @version v1.0
 * @since JDK 1.7+
 */
public interface SimHash extends Similar {

    /**
     *  判断是否相似
     * @param simHash
     * @return 相似-true，否则-false
     */
    public boolean similar(AbstractSimHash simHash);
    /**
     *  判断是否相似
     * @param simHash
     * @param similarDistance 相似汉明距离，默认3
     * @return 相似-true，否则-false
     */
    public boolean similar(AbstractSimHash simHash,int similarDistance);

    /**
     *  判断是否相似
     * @param s
     * @return 相似-true，否则-false
     */
    public boolean similar(String s);
    /**
     * 获取分段hash签名
     * @param distance
     * @return
     */
    public List<Long> subByDistance(int distance) ;
}
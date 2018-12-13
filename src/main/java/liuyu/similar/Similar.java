package liuyu.similar;

/**
 * ClassName: Similar <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date: 18-9-4 下午5:23 <br/>
 *
 * @author liuyu
 * @version v1.0
 * @since JDK 1.7+
 */
public interface Similar {
    /**
     * 判断是否相似
     *
     * @param tokens
     * @param similarThreshold
     * @return
     */
    public boolean similar(String tokens, int similarThreshold);
}

package liuyu.similar.simbash.support;

import java.io.Serializable;

/**
 * ClassName: AbstractNode <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date: 18-9-4 下午5:28 <br/>
 *
 * @author liuyu
 * @version v1.0
 * @since JDK 1.7+
 */
public abstract class AbstractNode implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -8888760553927452742L;
    private long id;//node的id
    private long subKey;//64位的分段key+key的的分段索引位置，如64位的key分四段的：1、2、3、4


    public AbstractNode() {
        super();
        // TODO Auto-generated constructor stub
    }

    public AbstractNode(long id, long subKey) {
        super();
        this.id = id;
        this.subKey = subKey;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSubKey() {
        return subKey;
    }

    public void setSubKey(long subKey) {
        this.subKey = subKey;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        AbstractNode node = (AbstractNode) obj;
        return this.subKey == node.subKey;
    }
}
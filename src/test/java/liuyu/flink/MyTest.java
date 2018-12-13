package liuyu.flink;

import org.apache.flink.calcite.shaded.com.google.common.collect.Lists;
import org.apache.flink.calcite.shaded.com.google.common.collect.Maps;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * ClassName: MyTest <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date: 18-9-17 下午5:20 <br/>
 *
 * @author liuyu
 * @version v1.0
 * @since JDK 1.7+
 */
public class MyTest {

    @Test
    public void test01() throws Exception {

        Map<String, List<Integer>> m1 = Maps.newHashMap();
        m1.put("1", Lists.newArrayList(1, 2, 3));
        m1.put("2", Lists.newArrayList(1, 2, 3));
        m1.put("3", Lists.newArrayList(1, 2, 3));

        Map<String, List<Integer>> m2 = Maps.newHashMap();
        m2.put("1", Lists.newArrayList(1, 2, 3));
        m2.put("4", Lists.newArrayList(1, 2, 3));

        m2.entrySet().parallelStream().map(entry -> {
            m1.merge(entry.getKey(), entry.getValue(), this::kk);
            return entry;
        }).count();

        m2.entrySet().stream().forEach(e->{
            m1.merge(e.getKey(), e.getValue(), (x,y)->{
                x.addAll(y);
                return x;
            });
        });

        System.out.println();
    }

    public List<Integer> kk(List<Integer> x,List<Integer> y){
        x.addAll(y);
        return x;
    }
}

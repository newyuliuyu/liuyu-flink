package liuyu.simhash2;

import java.math.BigInteger;
import java.util.*;

/**
 * ClassName: Simhash <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date: 18-9-4 下午1:19 <br/>
 *
 * @author liuyu
 * @version v1.0
 * @since JDK 1.7+
 */
public class Simhash {
    private List<Map<String, List<Long>>> storage = new ArrayList<>();// 按照分段存储simhash，查找更快速
    private int fracCount = 4; // 默认按照4段进行simhash存储
    private int hammingThresh = 3;// 汉明距离的衡量标准
    private int hashbits = 64;

    public Simhash() {
        this(4, 3);

    }

    public Simhash(int fracCount, int hammingThresh) {
        this.fracCount = fracCount;
        this.hammingThresh = hammingThresh;
        for (int i = 0; i < fracCount; i++) {
            storage.add(new HashMap<String, List<Long>>());
        }
    }

    public Long calSimhash(String content) {
        StringTokenizer stringTokens = new StringTokenizer(content);
        int[] weight = new int[hashbits];
        while (stringTokens.hasMoreTokens()) {
            String temp = stringTokens.nextToken();
            long wordHash = Murmur3.hash64(temp.getBytes());
//            long wordHash = MurmurHash.hash64(temp);
            for (int i = 0; i < hashbits; i++) {
                if (((wordHash >> i) & 1) == 1) {
                    weight[i] += 1;
                } else {
                    weight[i] -= 1;
                }
            }
        }

        // 计算得到Simhash值
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hashbits; i++) {
            if (weight[i] > 0) sb.append(1);
            else sb.append(0);
        }
        return new BigInteger(sb.toString(), 2).longValue();
    }

    public boolean isDuplicate(String content) {
        Long simhash = calSimhash(content);
        List<String> lFrac = splitSimhash(simhash, fracCount);
        int dis = 0;
        for (int i = 0; i < fracCount; i++) {
            String frac = lFrac.get(i);
            Map<String, List<Long>> fracMap = storage.get(i);
            if (fracMap.containsKey(frac)) {
                for (Long simhash2 : fracMap.get(frac)) {
                    if (hamming(simhash, simhash2) <= hammingThresh) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // 将simhash分成n段
    private List<String> splitSimhash(Long simhash, int n) {
        List<String> ls = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hashbits; i++) {
            sb.append(simhash >> i & 1);
            if ((i + 1) % n == 0) {
                ls.add(sb.toString());
                sb.setLength(0);
            }
        }
        return ls;
    }

    // 计算汉明距离
    public int hamming(Long s1, Long s2) {
        int dis = 0;
        for (int i = 0; i < hashbits; i++) {
            if ((s1 >> i & 1) != (s2 >> i & 1)) dis++;
        }
        return dis;
    }

    public int hamming2(long hash1, long hash2) {
        long i = hash1 ^ hash2;
        i = i - ((i >>> 1) & 0x5555555555555555L);
        i = (i & 0x3333333333333333L) + ((i >>> 2) & 0x3333333333333333L);
        i = (i + (i >>> 4)) & 0x0f0f0f0f0f0f0f0fL;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        i = i + (i >>> 32);
        return (int) i & 0x7f;
    }

    private int hamming(String s1, String s2) {
        if (s1.length() != s2.length()) return 0;
        int dis = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) dis++;
        }
        return dis;
    }


    public void store(Long simhash, String content) {
        List<String> lFrac = splitSimhash(simhash, fracCount);
        for (int i = 0; i < fracCount; i++) {
            String frac = lFrac.get(i);
            Map<String, List<Long>> fracMap = storage.get(i);
            if (fracMap.containsKey(frac)) {
                fracMap.get(frac).add(simhash);
            } else {
                List<Long> ls = new ArrayList<Long>();
                ls.add(simhash);
                fracMap.put(frac, ls);
            }
        }

    }
}

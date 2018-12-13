package liuyu.similar.simhash;

import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * ClassName: SimpleSimHash <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date: 18-9-4 下午5:36 <br/>
 *
 * @author liuyu
 * @version v1.0
 * @since JDK 1.7+
 */
public class SimpleSimHash extends AbstractSimHash {


    public SimpleSimHash(String tokens) {
        super(tokens);
    }

    public SimpleSimHash(String tokens, int hashbits) {
        super(tokens, hashbits);
    }

    @Override
    protected BigInteger simHash() {
        return getSimHash(tokens, hashbits);
    }

    public static BigInteger getSimHash(String tokens, int hashbits) {
        int[] v = new int[hashbits];
        StringTokenizer stringTokens = new StringTokenizer(tokens);
        while (stringTokens.hasMoreTokens()) {
            String temp = stringTokens.nextToken();
            BigInteger t = HelpUtils.hash(temp, hashbits);
            for (int i = 0; i < hashbits; i++) {
                BigInteger bitmask = new BigInteger("1").shiftLeft(i);
                if (t.and(bitmask).signum() != 0) {
                    v[i] += 1;
                } else {
                    v[i] -= 1;
                }
            }
        }
        BigInteger fingerprint = new BigInteger("0");
        for (int i = 0; i < hashbits; i++) {
            if (v[i] >= 0) {
                fingerprint = fingerprint.add(new BigInteger("1").shiftLeft(i));
            }
        }
        return fingerprint;
    }

    @Override
    public boolean similar(String s, int similarDistance) {
        return similar(new SimpleSimHash(s), similarDistance);
    }

    @Override
    public boolean similar(String s) {
        return similar(new SimpleSimHash(s));
    }
}

package practices.JCiP.Sample2;

import java.math.BigInteger;
import java.util.Arrays;

public class OneValueCache {

    private final BigInteger lastNumber;

    private final BigInteger[] lastFactors;


    public OneValueCache(BigInteger i, BigInteger[] factors) {
        this.lastNumber = i;
        this.lastFactors = Arrays.copyOf(factors, factors.length);

    }

    public BigInteger[] getFactors(BigInteger i) {
        if (lastNumber == null || !lastNumber.equals(i)) {
            return null;
        } else {
            return Arrays.copyOf(lastFactors, lastFactors.length);
        }
    }
}

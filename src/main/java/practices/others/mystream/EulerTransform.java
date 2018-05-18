package practices.others.mystream;

import java.util.function.Function;

public class EulerTransform implements Function<Double, Double> {


    private double n1 = 0.0, n2 = 0.0, n3 = 0.0;

    @Override
    public Double apply(Double t) {
        n1 = n2;
        n2 = n3;
        n3 = t;
        if (n1 == 0.0) {
            return 0.0;
        }
        return calc();
    }

    private Double calc() {
        double d = n3 - n2;
        return n3 - d * d / (n1 - 2 * n2 + n3);
    }


}

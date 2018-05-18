package practices.others.mystream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FirstStream {


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = numbers.stream();
        stream.filter((x) -> x % 2 == 0).map((x) -> x * x).forEach(System.out::println);
        getNatural();

        System.out.println("Get Pie:");
        getPie();

        System.out.println("Get Pie:");
        getPie2();

    }

    private static void getNatural() {
        Stream<Long> natural = Stream.generate(new NaturalSupplier());
        natural.map((x) -> x + " is a natural num.").limit(10).forEach(System.out::println);

    }

    private static void getPie() {
        Stream<Double> piStream = Stream.generate(new PiSupplier());
        piStream.skip(100).limit(10).forEach(System.out::println);
    }


    private static void getPie2() {
        Stream<Double> piStream = Stream.generate(new PiSupplier());
        piStream.map(new EulerTransform()).map(new EulerTransform()).
                map(new EulerTransform()).map(new EulerTransform()).
                map(new EulerTransform()).limit(20).forEach(System.out::println);
    }

    static class PiSupplier implements Supplier<Double> {

        double sum = 0.0;
        double current = 1.0;
        boolean sign = true;


        @Override
        public Double get() {
            sum += (sign ? 4 : -4) / this.current;

            this.current = this.current + 2.0;

            this.sign = !this.sign;
            return sum;
        }
    }

    static class NaturalSupplier implements Supplier<Long> {

        long val = 0;

        @Override
        public Long get() {
            this.val = this.val + 1;
            return this.val;
        }
    }


}

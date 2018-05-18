package practices.others.mystream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciStream {

    public static void main(String[] args) {

        Stream<Long> fibonacci = Stream.generate(new FibonacciSupplier());

        // fibonacci.limit(10).forEach(System.out::println);

        List<Long> list = fibonacci.skip(20).limit(10).collect(Collectors.toList());
        System.out.println(list);
    }

}
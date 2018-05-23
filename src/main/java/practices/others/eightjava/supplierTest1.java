package practices.others.eightjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;


public class supplierTest1 {


    public static final String ABCD = "abcd";
    public static final String ABC = "abc";

    public static void main1(String[] args) {

        // new operator itself is a supplier, of the reference to the newly created object
        Supplier<List<String>> listSupplier = ArrayList::new;
        Consumer<String> printConsumer = System.out::println;
        BiConsumer<Integer, Integer> sumConsumer = (int1, int2) -> System.out.println(int1 + int2);

        Consumer<String> stringConsumer = (s) -> System.out.println(s.length());

        String a = "a";
        Arrays.asList("ab", ABC, a, ABCD).forEach(stringConsumer);
        Arrays.asList("ab", "abc", a, "abcd").forEach(printConsumer);
        List<String> aStrArr = listSupplier.get();
        aStrArr.add("abc-xyz");
        aStrArr.forEach(printConsumer);

        sumConsumer.accept(3, 30);

        Supplier<List<String>> listSupplier1 = () -> {

            ArrayList<String> list = new ArrayList<>();

            list.add("owner");
            list.add("guest");

            return list;

        };

        printWrapper();

        List<String> list = listSupplier1.get();
        list.forEach(printConsumer);
    }

    private static void printWrapper() {
        System.out.println("---------------------");
    }


    public static void main(String[] args) {

        int x = 2 << 7 - 2 * 3;
        System.out.println(x);
        int y = 2 << 7;
        System.out.println(y);

    }
}

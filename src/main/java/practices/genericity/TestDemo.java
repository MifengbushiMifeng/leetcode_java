package practices.genericity;

public class TestDemo {

    private static void testT() {
        Test<Integer> intObj = new Test<>(88);
        intObj.showActuallyType();
        int i = intObj.getObj();
        System.out.println("value = " + i);
        System.out.println("-----------------------------");

        Test<String> strObj = new Test<>("Hello!");
        strObj.showActuallyType();
        String s = strObj.getObj();
        System.out.println("value = " + s);
    }

    private static void testT2() {
        Test2 intObj = new Test2(99);
        intObj.showActuallyType();
        int i = (Integer) intObj.getObj();
        System.out.println("value = " + i);
        System.out.println("-----------------------------");

        Test2 strObj = new Test2("Hello 2");
        strObj.showActuallyType();
        String s = (String) strObj.getObj();
        System.out.println("value = " + s);

    }

    public static void main(String[] args) {

        testT();
        testT2();
    }
}

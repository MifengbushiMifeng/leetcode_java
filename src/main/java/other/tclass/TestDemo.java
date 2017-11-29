package other.tclass;

public class TestDemo {

    public static void main(String[] args) {

        Test<Integer> intOb = new Test<Integer>(33);
        intOb.showType();
        int i = intOb.getOb();
        System.out.println("value= " + i);

        System.out.println("----------------");

        Test<String> strOb = new Test<String>("Hello world!");
        strOb.showType();
        String s = strOb.getOb();
        System.out.println("value= " + s);
    }
}

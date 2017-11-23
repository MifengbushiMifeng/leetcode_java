package other.tcalss;

public class TestDemo2 {

    public static void main(String[] args) {

        Test2 intObj = new Test2(33);
        intObj.showType();
        int i = (Integer) intObj.getObj();
        System.out.println("value= " + i);

        System.out.println("---------------------");

        Test2 strObj = new Test2("Hello world!");
        strObj.showType();
        String s = (String) strObj.getObj();
        System.out.println("value= " + s);
    }
}

package practices.others;

public class IntegerTest {

    /**
     * https://blog.csdn.net/qq_27093465/article/details/52033409
     */
    private static void objPoolTest() {

        Integer i1 = 30;
        Integer i2 = 30;
        Integer i3 = 0;
        Integer i4 = new Integer(30);
        Integer i5 = new Integer(30);
        Integer i6 = new Integer(0);

        System.out.println("i1=i2\t" + (i1 == i2));
        System.out.println("i1=i2+i3\t" + (i1 == i2 + i3));
        System.out.println("i4=i5\t" + (i4 == i5));
        System.out.println("i4=i5+i6\t" + (i4 == i5 + i6));

        System.out.println();
    }

    private static void objPoolTest2() {

        Integer i1 = 300;
        Integer i2 = 300;
        Integer i3 = 0;
        Integer i4 = new Integer(300);
        Integer i5 = new Integer(300);
        Integer i6 = new Integer(0);

        System.out.println("i1=i2\t" + (i1 == i2));
        System.out.println("i1=i2+i3\t" + (i1 == i2 + i3));
        System.out.println("i4=i5\t" + (i4 == i5));
        System.out.println("i4=i5+i6\t" + (i4 == i5 + i6));

        System.out.println();
    }

    public static void main(String[] args) {
        objPoolTest();
        objPoolTest2();
    }
}



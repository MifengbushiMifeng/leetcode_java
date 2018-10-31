package practices.thinkin.p2;

public class FieldAccess {

    public static void main(String[] args) {
        int cidrMask = 31;
        long bits = 0;
        bits = 0xffffffff ^ (1 << 32 - cidrMask) - 1;
        String mask = String.format("%d.%d.%d.%d", (bits & 0x0000000000ff000000L) >> 24, (bits & 0x0000000000ff0000) >> 16, (bits & 0x0000000000ff00) >> 8, bits & 0xff);
        System.out.println(mask);
        //        Super sup = new Sub();
//        System.out.println("sup.filed = " + sup.field +
//                ", sup.getField() = " + sup.getField());
//        Sub sub = new Sub();
//        System.out.println("sub.filed = " + sub.field +
//                ", sub.getField() = " + sub.getField() +
//                ", sub.getSuperField() = " + sub.getSuperField());
    }
}

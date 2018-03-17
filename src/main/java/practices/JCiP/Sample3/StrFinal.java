package practices.JCiP.Sample3;

public class StrFinal {
    public static String appendStr(String s) {
        s += "bbb";
        return s;
    }

    public static StringBuilder appendSB(StringBuilder sb) {
        return sb.append("bbb");
    }

    public static void main(String[] args) {


        String s = new String("aaa");
        String ns = StrFinal.appendStr(s);
        System.out.println("String aaa >>> " + s);

        StringBuilder sb = new StringBuilder("aaa");
        StringBuilder nsb = StrFinal.appendSB(sb);
        System.out.println("StringBuilder aaa >>>" + sb.toString());
    }
}

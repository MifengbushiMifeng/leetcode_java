package practices.equalsprac;


public class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String inString) {
        if (inString == null) {
            throw new NullPointerException();
        }

        this.s = inString;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
        }
        if (obj instanceof String) {
            return s.equalsIgnoreCase((String) obj);
        }

        return false;
    }

    public static void main(String[] args) {

        CaseInsensitiveString cis = new CaseInsensitiveString("Case");

        System.out.println(cis.equals("case"));
        System.out.println("case".equals(cis));

    }
}

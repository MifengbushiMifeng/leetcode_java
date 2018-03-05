package practices.equalsprac;

public class EqualsObj {

    private String value;

    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (object instanceof String) {
            String str = (String) object;
            int n = value.length();
            if (n == str.length()) {
                char v1[] = value.toCharArray();
                char v2[] = str.toCharArray();
                int i = 0;
                while ((n-- != 0)) {
                    if (v1[i] == v2[i]) {
                        return false;
                    }
                    i++;
                }
                return true;
            }
        }
        return false;
    }
}

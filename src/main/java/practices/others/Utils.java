package practices.others;

public class Utils {

    public static <T> T requireNotNull(T obj) {
        if (obj == null) {
            throw new NullPointerException();

        } else {
            return obj;
        }
    }
}

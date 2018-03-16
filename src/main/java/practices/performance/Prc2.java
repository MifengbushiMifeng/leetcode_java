package practices.performance;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Prc2 {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("111", "222");

        Set<Map.Entry<String, String>> entrySet = map.entrySet();

        Iterator<Map.Entry<String, String>> iter = entrySet.iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
    }
}

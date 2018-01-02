package practices.uuid;

import java.util.UUID;

/**
 * UUID : Universally Unique Identifier.
 */
public class Main {


    public static void main(String[] args) {

        String[] uuids = getUUIDs();
        for (String uuid : uuids) {
            System.out.println(uuid);
        }

    }

    private static String[] getUUIDs() {

        String[] uuids = new String[10];

        for (int i = 0; i < 10; i++) {
            String uuid = UUID.randomUUID().toString();
            uuids[i] = uuid;
        }
        return uuids;
    }

}

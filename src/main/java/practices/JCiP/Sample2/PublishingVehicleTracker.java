package practices.JCiP.Sample2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by CISCO : jonzhou on 2018/3/17.
 * <p>
 * The usage of this class is ...
 */
public class PublishingVehicleTracker {

    private final Map<String, SafePoint> locations;

    private final Map<String, SafePoint> unmodifiableMap;


    public PublishingVehicleTracker(Map<String, SafePoint> locations) {
        this.locations = new ConcurrentHashMap<>(locations);
        this.unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String, SafePoint> getLocations() {
        return unmodifiableMap;
    }

    public void setLocations(String id, int x, int y) {
        if (!this.locations.containsKey(id)) {
            throw new IllegalArgumentException("invalid vehicle name: " + id);
        }
        locations.get(id).set(x, y);
    }

    public static void main(String[] args) {
        final int[] arr = {1, 2, 3};
        Array.set(arr, 2, 11);
        System.out.println(Arrays.toString(arr));
    }
}

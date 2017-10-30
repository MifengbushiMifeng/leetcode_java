package algorithms.twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_O_n {

    public static int[] twoSum(int[] numbers, int target) {
        /*int[] result = new int[2];*/

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                /*result[1] = i + 1;
                result[0] = map.get(target - numbers[i]);
                return result;*/
                return new int[]{map.get(target - numbers[i]), i};
            }
            map.put(numbers[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
        /*return result;*/
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " / " + result[1]);

    }
}

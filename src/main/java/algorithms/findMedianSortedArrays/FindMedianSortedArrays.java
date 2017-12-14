package algorithms.findMedianSortedArrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 * <p>
 * <p>
 * when odd:  m0.5 = X(n + 1) / 2
 * when even: m0.5 = X(n / 2) + X(n / 2+1)  /  2
 */
public class FindMedianSortedArrays {

    public static double findMedianSortedArrays(int[] num1, int[] num2) {

        double result = 0;



        return result;
    }

    public static void main(String[] args) {

        int[] num1 = {1, 3, 5, 7};
        int[] num2 = {2, 4, 11, 15};
        System.out.println(findMedianSortedArrays(num1, num2));
    }

}

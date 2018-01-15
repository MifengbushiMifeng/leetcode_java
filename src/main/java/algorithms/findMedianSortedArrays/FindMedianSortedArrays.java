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

    private static double findMedianSortedArrays(int[] num1, int[] num2) {

        int m = num1.length;
        int n = num2.length;

        // ensure  m <= n
        if (m > n) {
            int[] tmp = num1;
            num1 = num2;
            num2 = tmp;
            m = num1.length;
            n = num2.length;
        }

        int iMin = 0;
        int iMax = m;
        int halfLen = (m + n + 1) / 2;

        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;

            // i is too small
            if (i < iMax && num2[j - 1] > num1[i]) {
                iMin = iMin + 1;
            }

            // i is too big
            else if (i > iMin && num2[j] < num1[i - 1]) {
                iMax = iMax - 1;
            }
            // i is perfect
            else {
                int maxLeft = 0;

                if (i == 0) {
                    maxLeft = num2[j - 1];
                } else if (j == 0) {
                    maxLeft = num1[i - 1];
                } else {
                    maxLeft = Math.max(num1[i - 1], num2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = num2[j];
                } else if (j == n) {
                    minRight = num1[i];
                } else {
                    minRight = Math.min(num2[j], num1[i]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }


        return 0.0;
    }

    public static void main(String[] args) {

        int[] num1 = {};
        int[] num2 = {1};
        System.out.println(findMedianSortedArrays(num1, num2));
    }

}

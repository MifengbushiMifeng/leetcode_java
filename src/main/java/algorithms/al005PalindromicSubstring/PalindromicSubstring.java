package algorithms.al005PalindromicSubstring;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example:
 * <p>
 * Input: "babad"
 * <p>
 * Output: "bab"
 * <p>
 * Note: "aba" is also a valid answer.
 * Example:
 * <p>
 * Input: "cbbd"
 * <p>
 * Output: "bb"
 */
public class PalindromicSubstring {

    public static String longestPalindrome(String s) {


        char[] chars = s.toCharArray();

        for (char ch : chars) {
            // TODO
        }

        return "";
    }

    public static void main(String[] args) {
        String testStr = "babad";
        longestPalindrome(testStr);

    }

}

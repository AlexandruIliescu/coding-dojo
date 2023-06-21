package leetcode.random;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        longestCommonPrefix(strs);
    }

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int index = 0;
        while (index < s1.length() && index < s2.length()) {
            if (s1.charAt(index) == s2.charAt(index)) {
                index++;
            } else {
                break;
            }
        }
        return s1.substring(0, index);
    }
    /**Time complexity
     * O(n * m * log(n))
     * Sorting the strs array takes O(n * log(n)) time complexity.
     * Finding the longest common prefix requires comparing characters
     * from the first and last string, which takes O(m) time in the worst case.
     *
     * Space complexity
     * Space used by two string variables s1 & s2 is proportional to the
     * length of the longest string in the array => space complexity O(1)
     */
}
//https://leetcode.com/problems/longest-common-prefix/
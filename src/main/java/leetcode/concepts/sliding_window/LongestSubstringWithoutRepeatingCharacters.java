package leetcode.concepts.sliding_window;

/**
 * The sliding window algorithm is a technique used to efficiently process subarrays or sublists
 * of a given array or list. It involves maintaining a window (a fixed-size subset)
 * that "slides" through the array or list, dynamically adjusting its boundaries as needed.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int count = 0;
        int maxLength = 0;

        while (right < s.length()) {
            char currentChar = s.charAt(right);

            //check if the current character is already present in the substring
            for (int i = left; i < right; i++) {
                if (s.charAt(i) == currentChar) {
                    //update the left pointer to skip the repeated character
                    left = i + 1;
                    break;
                }
            }

            //update the current substring length
            count = right - left + 1;

            //update the maximum length if necessary
            maxLength = Math.max(maxLength, count);

            right++;
        }

        return maxLength;
    }
}
//https://leetcode.com/problems/longest-substring-without-repeating-characters/
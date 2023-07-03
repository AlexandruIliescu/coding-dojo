package leetcode.concepts.two_pointers;

public class TP_LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLength = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            // Expand around the center for odd-length palindromes
            int len1 = expandAroundCenter(s, i, i);

            // Expand around the center for even-length palindromes
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > maxLength) {
                maxLength = len;
                start = i - (len - 1) / 2; // Update the start index of the longest palindrome
            }
        }

        return s.substring(start, start + maxLength);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // Return the length of the palindrome
        return right - left - 1;
    }
}
//https://leetcode.com/problems/longest-palindromic-substring/description/
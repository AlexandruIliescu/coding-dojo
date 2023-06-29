package leetcode.concepts.two_pointers;

public class TP_ValidPalindrome {

    public static void main(String[] args) {

    }

    /**
     * time complexity O(n)
     * space compelxity O(1)
     */
    public boolean isPalindrome(String s) {
        String data = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = data.length() - 1;

        while (left < right) {
            if (data.charAt(left) != data.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public boolean isPalindrome2(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            } else {
                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;
    }
}
//https://leetcode.com/problems/valid-palindrome/
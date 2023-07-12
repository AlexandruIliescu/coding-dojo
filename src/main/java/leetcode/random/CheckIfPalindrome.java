package leetcode.random;

public class CheckIfPalindrome {

    public static void main(String[] args) {
        String input = "level";
        System.out.println(isPalindrome(input));
    }

    public static boolean isPalindrome(String input) {
        int left = 0;
        int right = input.length() - 1;

        while (left <= right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

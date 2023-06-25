package leetcode.concepts.recursion;

//spelled the same backward: kayak
public class PalindromeWithRecursion {

    public static void main(String[] args) {
        System.out.println(isPalindrome("kayak"));
    }

    public static boolean isPalindrome(String input) {
        //define the best case / stopping condition
        if (input.length() == 0 || input.length() == 1) {
            return true;
        }

        //do some work to shrink the problem space
        if (input.charAt(0) == input.charAt(input.length() - 1)) {
            return isPalindrome(input.substring(1, input.length() - 1));
        }

        //additional base case to handle non-palindromes
        return false;
    }
}
//https://www.youtube.com/watch?v=IJDJ0kBx2LM
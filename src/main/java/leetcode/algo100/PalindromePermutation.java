package leetcode.algo100;

import java.util.BitSet;

public class PalindromePermutation {

    public static void main(String[] args) {
        isPalindrome("aab");
    }

    /**
     * If the cardinality is less than 2, it means there
     * is at most one character with an odd occurrence in the string.
     * In a palindrome, at most one character can have an odd
     * occurrence (e.g., in "racecar", the character 'e' occurs odd times),
     * so this check is used to determine if the string can form a palindrome.
     */
    private static boolean isPalindrome(String s) {
        BitSet bs = new BitSet();
        for (byte b : s.getBytes()) {
            bs.flip(b);
        }
        return bs.cardinality() < 2;
    }
}
//https://leetcode.com/problems/palindrome-permutation/description/?envType=study-plan-v2&envId=premium-algo-100
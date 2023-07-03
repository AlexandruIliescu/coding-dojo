package leetcode.concepts.greedy;

import java.util.Arrays;

public class NextGreaterElement_III {

    public int nextGreaterElement(int n) {
        //convert the number to an array of digits
        char[] digits = String.valueOf(n).toCharArray();

        //find the first digit that is smaller than the digit on its right
        int i;
        for (i = digits.length - 2; i >= 0; i--) {
            if (digits[i] < digits[i + 1]) {
                break;
            }
        }

        //if no such digit is found, return -1
        if (i < 0) {
            return -1;
        }

        //find the smallest digit greater than digits[i] to its right
        int j;
        for (j = digits.length - 1; j > i; j--) {
            if (digits[j] > digits[i]) {
                break;
            }
        }

        //swap digits[i] and digits[j]
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        //sort the digits to the right of digits[i] in ascending order
        Arrays.sort(digits, i + 1, digits.length);

        //convert the updated digits array back to an integer
        long result = Long.parseLong(String.valueOf(digits));

        //check if the result exceeds the 32-bit integer limit
        if (result > Integer.MAX_VALUE) {
            return -1;
        }

        return (int) result;
    }
}
//https://leetcode.com/problems/next-greater-element-iii/
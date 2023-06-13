package amazon;

public class ReverseInteger {

    //https://leetcode.com/problems/reverse-integer/

    //time complexity O(n)
    //we have a total of n digits in our input x
    //we must perform the calculations for each digit in our while loop

    //space complexity O(1)
    //no extra space needed
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            int remainder = x % 10;
            result = result * 10 + remainder;
            if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int) result;
    }
}
package leetcode.concepts.greedy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RemoveKDigits {

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;

        Queue<Integer> queue = new LinkedList<>();


        System.out.println(removeKdigits(num, k));
    }

    public static String removeKdigits(String num, int k) {
        int len = num.length();

        //if k == length of num, we can remove all digits
        if (k == len) {
            return "0";
        }

        //use stack to store the digits in decreasing order
        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        //if k is still greater than 0, remove the remaining k digits from the stack
        while (k > 0) {
            stack.pop();
            k--;
        }

        //construct the resulting number by concatenatig the digits from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            //values are stored in stack in reversed order
            //we need to
            sb.insert(0, stack.pop());
        }

        //handle leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
//https://leetcode.com/problems/remove-k-digits/
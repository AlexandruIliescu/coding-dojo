package leetcode.concepts.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class FibonacciWithMap {

    private static final Map<Integer, Integer> memo = new HashMap<>();

    //given a number n, return the index value for the fibonacci sequence
    //fib sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55...

    /**
     * time complexity O(2^n)
     */
    static int fib(int number) {
        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        }

        return fib(number - 1) + fib(number - 2);
    }

    /**
     * time complexity O(n)
     * with memoization
     */
    static int fibMemo(int number) {
        if (number <= 1) {
            return number;
        }

        //check if the value is in the map
        if (memo.containsKey(number)) {
            return memo.get(number);
        }

        //calculate fibonacci value and store it in the memo map
        int result = fibMemo(number - 1) + fibMemo(number - 2);
        memo.put(number, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fibMemo(10));
    }
}
package leetcode.dynamic_programming;

public class FibonacciDP {

    //used for memoization
    private static long[] fibonacciCache;

    public static void main(String[] args) {
        int n = 50;

        fibonacciCache = new long[n + 1];

//        System.out.println(getFib(n));
        System.out.println(getFibWithMemoization(n));
    }

    /**
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     */
    private static long getFib(int n) {
        if (n < 2) {
            return n;
        }
        return getFib(n - 1) + getFib(n - 2);
        //f(5) = f(4) + f(3)
        //f(4) = f(3) + f(2)
        //f(3) = f(2) + f(1) (all this just for the fist recursion series
        //we can use memoization to improve this
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    private static long getFibWithMemoization(int n) {
        if (n < 2) {
            return n;
        }
        if (fibonacciCache[n] != 0) {
            return fibonacciCache[n];
        }
        long nthFibonacciNumber = getFibWithMemoization(n - 1) + getFibWithMemoization(n - 2);
        fibonacciCache[n] = nthFibonacciNumber;

        return nthFibonacciNumber;
    }

    /**
     * Time Complexity: O(2^n)
     * Space Complexity: O(n) (due to the recursion stack)
     */
    private static int getFib2(int n) {
        int[] fibArray = new int[n + 1];
        fibArray[0] = 0;
        fibArray[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }

        return fibArray[n];
    }

    /**
     * In the recursive approach, the time complexity is exponential, O(2^n). This is because for each Fibonacci number,
     * the function makes two recursive calls to calculate the previous two Fibonacci numbers. As a result, the number
     * of function calls and redundant computations grow exponentially with the input value n. T
     * The space complexity is O(n) because the recursion stack holds the function calls until they reach the base case,
     * resulting in a stack depth of n.
     *
     * In terms of time complexity, the dynamic programming approach is significantly more efficient than the recursive
     * approach. The dynamic programming approach calculates Fibonacci numbers in linear time, while the recursive
     * approach has exponential time complexity. As a result, the dynamic programming approach is preferred for larger
     * values of n.
     *
     * The space complexity is comparable between the two approaches, with the dynamic programming approach utilizing
     * additional space to store the array of Fibonacci numbers.
     *
     * Remember that each recursive algorithm has to contain a base case, to avoid infinite recursion.
     * Int our case it's
     * if (n < 2) {
     *    return n;
     * }
     * https://www.youtube.com/watch?v=cum3OrpURzc
     */
}
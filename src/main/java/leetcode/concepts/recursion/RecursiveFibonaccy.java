package leetcode.concepts.recursion;

public class RecursiveFibonaccy {

    public static void main(String[] args) {

    }

    private static long fibNonOptimized(long n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibNonOptimized(n - 1) + fibNonOptimized(n - 2);
        }
    }

    //with memoization - makes application more efficient and faster
    private static long fibWithMemoization(int n, Long[] memo) {
        if (n == 0 || n == 1) {
            return n;
        }
        //check if the Fibonacci number has already been computed
        if (memo[n] != null) {
            return memo[n];
        }
        //compute and memoize the Fibonacci number
        long fib = fibWithMemoization(n - 1, memo) + fibWithMemoization(n - 2, memo);
        memo[n] = fib;

        return fib;
    }
}

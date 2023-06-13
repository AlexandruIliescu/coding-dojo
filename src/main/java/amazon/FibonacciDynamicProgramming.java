package amazon;

public class FibonacciDynamicProgramming {

    //https://leetcode.com/problems/fibonacci-number/

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }

    public int fib(int n) {
        int[] fib = new int[n + 2];
        fib[0] = 0;
        fib[1] = 1;

        for(int i = 2; i <= n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }

    public static int fibonacci(int n) {
        if(n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
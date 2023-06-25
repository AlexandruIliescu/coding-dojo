package leetcode.concepts.recursion;

public class RecursiveSum {

    public static void main(String[] args) {
        System.out.println(recursiveEvenSum(7));
    }

    /**
     * time complexity O(n)
     * space complexity O(n)
     */
    private static int recursiveSum(int input) {
        if (input <= 1) {
            return input;
        }
        return input + recursiveSum(input - 1);
    }

    /**
     * time complexity O(n/2)
     * space complexity O(n)
     */
    private static int recursiveEvenSum(int input) {
        if (input < 1) {
            return input;
        }
        boolean isInputEvenNumber = input % 2 == 0;
        if (isInputEvenNumber) {
            return input + recursiveEvenSum(input - 2);
        } else {
            return recursiveEvenSum(input - 1);
        }
    }

}

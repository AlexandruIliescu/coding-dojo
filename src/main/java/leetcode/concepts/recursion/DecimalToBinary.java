package leetcode.concepts.recursion;

public class DecimalToBinary {

    public static void main(String[] args) {
        System.out.println(findBinary(233, ""));
    }

    public static String findBinary(int decimal, String result) {
        if (decimal == 0) {
            return result;
        }

        result = decimal % 2 + result;
        return findBinary(decimal / 2, result);
    }

    /**
     * time complexity O(log2(decimal)) because in each recursive call, the decimal value
     * is divided by 2
     *
     * space complexity O(log2(decimal))
     */
}
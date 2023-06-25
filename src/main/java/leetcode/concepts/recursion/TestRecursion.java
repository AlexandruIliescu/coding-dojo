package leetcode.concepts.recursion;

public class TestRecursion {

    public static void main(String[] args) {
        System.out.println(countLetters("abc"));
    }

    private static int countLetters(String input) {
        //define stop condition / base case
        if (input.isEmpty()) {
            return 0;
        }
        //recursive case
        return 1 + countLetters(input.substring(1));
    }

    /**
     * The time complexity of the countLetters function is O(n),
     * where n is the length of the input string. This is because in each recursive call,
     * we reduce the length of the string by 1 (str.substring(1)), and we make a total of n recursive calls
     * until the base case is reached. Therefore, the time complexity is linear with respect to the length of the string.
     *
     * The space complexity of the countLetters function is also O(n), where n is the length of the input string.
     * This is because in each recursive call, a new substring is created (str.substring(1)), which requires
     * additional space. The maximum depth of the recursion is equal to the length of the string, so the space
     * complexity is proportional to the length of the string.
     */
}
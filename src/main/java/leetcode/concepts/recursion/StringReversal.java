package leetcode.concepts.recursion;

public class StringReversal {

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
    }

    public static String reverseString(String input) {
        //what is the best case? when I can no longer continue?
        //what is the smallest amount of work I can do in each iteration?
        if (input.equals("")) {
            return "";
        }
        return reverseString(input.substring(1)) + input.charAt(0);
    }
}
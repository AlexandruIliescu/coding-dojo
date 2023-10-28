package leetcode.random;

public class ReverseString {

    public static void main(String[] args) {
        String name = "test";

        StringBuilder sb = new StringBuilder();
        for (int i = name.length() - 1; i >= 0; i--) {
            sb.append(name.charAt(i));
        }
        System.out.println(sb);
    }
}
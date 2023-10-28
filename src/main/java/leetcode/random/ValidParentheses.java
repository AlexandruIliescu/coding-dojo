package leetcode.random;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(validParentheses("{}"));
    }

    public static boolean validParentheses(String input) {
        if (input.length() % 2 != 0) {
            return false;
        }

        Stack<String> stack = new Stack();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[') {
                stack.push(String.valueOf(input.charAt(i)));
            } else {
                if (stack.isEmpty() || (stack.peek().equals(String.valueOf(input.charAt(i))))) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean validParenthesesSwitch(String input) {
        if (input.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    }
                    stack.pop();
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{') {
                        return false;
                    }
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return false;
                    }
                    stack.pop();
                    break;
                default:
                    return false; // Invalid character
            }
        }

        return stack.isEmpty();
    }
}
package leetcode.concepts.stack;

import java.util.Stack;

public class ValidParantheses {

    /**
     * Push: Adds an element onto the stack.
     * If the stack is full, it results in a condition known as stack overflow.
     *
     * Pop: Removes an element from the stack (and returns it)
     * The items are popped in the reversed order in which they are pushed.
     * If the stack is empty, it results in a condition known as stack underflow.
     *
     * Peek/Top: Returns the top element of the stack.
     *
     * isEmpty: Checks if the stack is empty.
     */
    public boolean isValid(String s) {
        //LIFO
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    //stack is empty but closing bracket was found
                    return false;
                }

                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    //closing bracket does not correspond to the type of the last open bracket
                    return false;
                }
            }
        }
        //if stack is not empty at the end, an open bracket was not close
        return stack.isEmpty();
    }
}
//https://leetcode.com/problems/valid-parentheses/
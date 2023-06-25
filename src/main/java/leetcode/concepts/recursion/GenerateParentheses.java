package leetcode.concepts.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generate(combinations, "", 0, 0, n);
        return combinations;
    }

    private void generate(List<String> combinations, String current, int openCount, int closeCount, int n) {
        //base case: if both openCount and closeCount reach n, add current combination to the result
        if (openCount == n && closeCount == n) {
            combinations.add(current);
            return;
        }

        //if the openCount is less than n, we can add an open parathesis '('
        if (openCount < n) {
            generate(combinations, current + "(", openCount + 1, closeCount, n);
        }

        //if the closeClount is less than openCount, we can add a close paranthesis ')'
        if (closeCount < openCount) {
            generate(combinations, current + ")", openCount, closeCount + 1, n);
        }
    }
}
//https://leetcode.com/problems/generate-parentheses/
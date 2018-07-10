package leetcode.string;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    private static final String OPEN = "(";
    private static final String CLOSE = ")";

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String soFar, int open, int close, int max) {
        // Returns when all parentheses are used already.
        if (soFar.length() == max * 2) {
            result.add(soFar);
            return;
        }

        // Adds an opening bracket if possible.
        if (open < max) {
            backtrack(result, soFar + OPEN, open + 1, close, max);
        }

        // Adds an closed bracket if possible.
        if (close < open) {
            backtrack(result, soFar + CLOSE, open, close + 1, max);
        }
    }
}

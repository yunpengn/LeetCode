package leetcode;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();

        for (char c: s.toCharArray()) {
            if (isOpenBracket(c)) {
                brackets.push(c);
            } else if (brackets.empty() || !matches(brackets.pop(), c)) {
                return false;
            }
        }
        return brackets.empty();
    }

    private boolean isOpenBracket(char character) {
        return character == 40 || character == 91 || character == 123;
    }

    private boolean matches(char open, char rhs) {
        if (open == 40) {
            return rhs == 41;
        } else if (open == 91) {
            return rhs == 93;
        } else if (open == 123) {
            return rhs == 125;
        } else {
            return false;
        }
    }
}

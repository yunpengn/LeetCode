package leetcode.string;

import java.util.Stack;

public class LongestValidParentheses {
    private static final char OPEN = 40;

    public int longestValidParentheses(String s) {
        Stack<Integer> ranges = new Stack<>();

        // Makes sure the stack is only left with those who are not in the valid ranges.
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == OPEN) {
                ranges.push(i);
            } else if (!ranges.isEmpty() && s.charAt(ranges.peek()) == OPEN) {
                ranges.pop();
            } else {
                ranges.push(i);
            }
        }

        // Returns if the whole string is valid.
        if (ranges.isEmpty()) {
            return s.length();
        }

        // Finds the largest consecutive range.
        int right = s.length() - 1;
        int soFar = 0;
        while(right >= 0 && !ranges.isEmpty()) {
            int left = ranges.pop();
            if (right - left > soFar) {
                soFar = right - left;
            }
            right = left - 1;
        }

        return Math.max(soFar, right + 1);
    }
}

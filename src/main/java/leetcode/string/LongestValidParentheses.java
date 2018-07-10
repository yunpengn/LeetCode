package leetcode.string;

public class LongestValidParentheses {
    private static final char OPEN = 40;

    public int longestValidParentheses(String s) {
        // Pointer for the index of the current element.
        int pointer = 0;

        // Takes note of the number of opening/closed brackets.
        int open = 0;
        int close = 0;

        // The best result so far.
        int soFar = 0;

        while (pointer < s.length()) {
            while (open >= close) {
                // Special case at the end of the whole string.
                if (pointer >= s.length()) {
                    return Math.max(fromBack(s), soFar);
                }

                if (s.charAt(pointer) == OPEN) {
                    open++;
                } else {
                    close++;
                }
                pointer++;
            }

            int size = Math.min(open, close) * 2;
            if (size > soFar) {
                soFar = size;
            }
            open = 0;
            close = 0;
        }

        return soFar;
    }

    private int fromBack(String s) {
        // Pointer for the index of the current element.
        int pointer = s.length() - 1;

        // Takes note of the difference of opening/closed brackets.
        int diff = 0;

        while (diff >= 0 && pointer >= 0) {
            if (s.charAt(pointer) != OPEN) {
                diff++;
            } else {
                diff--;
            }
            pointer--;
        }

        if (pointer < 0 && diff == 0) {
            return s.length();
        } else {
            return s.length() - pointer - 2;
        }
    }
}

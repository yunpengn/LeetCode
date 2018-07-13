package leetcode.string;

public class Regex {
    private static final char WILDCARD = 46;
    private static final char MULTIPLE = 42;

    /**
     * Checks whether a given string matches a certain pattern.
     *
     * @param s is the input string.
     * @param p is the input pattern.
     *
     * @return true if matched; false otherwise.
     */
    public boolean isMatch(String s, String p) {
        // Handles special cases first.
        if (s == null || p == null) {
            return false;
        } else if (s.length() == 0 && p.length() == 0) {
            return true;
        } else if (s.length() != 0 && p.length() == 0) {
            return false;
        } else if (p.charAt(0) == MULTIPLE) {
            // Invalid pattern.
            return false;
        }

        /*
         * Uses a 2D array to achieve dynamic programming. This 2D array can be thought
         * of as, until a certain point, whether the string matches the pattern or not.
         *
         * We use length() + 1 so that edge cases are easier to handle.
         */
        boolean[][] result = new boolean[s.length() + 1][p.length() + 1];
        // "" (empty pattern) will always match "" (empty string).
        result[0][0] = true;

        // Fills in the those prefixed with one or more MULTIPLE "*" patterns first.
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == MULTIPLE && result[0][i - 1]) {
                result[0][i + 1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == WILDCARD || p.charAt(j) == s.charAt(i)) {
                    // One-to-one matching (most simple case).
                    result[i + 1][j + 1] = result[i][j];
                } else if (p.charAt(j) == MULTIPLE) {
                    if (p.charAt(j - 1) == WILDCARD || p.charAt(j - 1) == s.charAt(i)) {
                        result[i + 1][j + 1] =  result[i + 1][j - 1]    // x* matches no x.
                                        || result[i + 1][j]             // x* matches exactly one x.
                                        || result[i][j + 1];            // x* matches multiple x's.
                    } else {
                        // x* matches no x.
                        result[i + 1][j + 1] = result[i + 1][j - 1];
                    }
                }
            }
        }

        return result[s.length()][p.length()];
    }
}

package leetcode.string;

public class WildcardMatching {
    private static final char WILDCARD = 63;
    private static final char MULTIPLE = 42;

    public boolean isMatch(String s, String p) {
        boolean[][] matched = new boolean[s.length() + 1][p.length() + 1];
        matched[0][0] = true;

        // Fills in the those prefixed with one or more MULTIPLE "*" patterns first.
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == MULTIPLE && matched[0][i]) {
                matched[0][i + 1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == WILDCARD || s.charAt(i) == p.charAt(j)) {
                    matched[i + 1][j + 1] = matched[i][j];
                } else if (p.charAt(j) == MULTIPLE) {
                    matched[i + 1][j + 1] = matched[i][j]   // * matches 1 character
                            || matched[i][j + 1]            // * matches multiple characters
                            || matched[i + 1][j];           // * matches 0 character
                }
            }
        }

        return matched[s.length()][p.length()];
    }
}


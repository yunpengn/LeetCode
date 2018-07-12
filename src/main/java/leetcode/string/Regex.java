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
        // The current index regarding the input string.
        int indexS = 0;
        // The current index regarding the pattern.
        int indexP = 0;

        while (indexP < p.length() && indexS < s.length()) {
            if (p.charAt(indexP) == WILDCARD) {
                indexS++;
                indexP++;
            } else if (p.charAt(indexP) == MULTIPLE) {
                if (indexP == 0) {
                    return false;
                } else if (p.charAt(indexP - 1) == s.charAt(indexS) || p.charAt(indexP - 1) == WILDCARD) {
                    indexS++;
                } else {
                    indexP++;
                }
            } else if (p.charAt(indexP) == s.charAt(indexS)) {
                indexS++;
                indexP++;
            } else {
                return false;
            }
        }

        if (indexP < p.length() && p.charAt(indexP) == MULTIPLE) {
            indexP = p.length();
        }

        return indexP == p.length() && indexS == s.length();
    }
}

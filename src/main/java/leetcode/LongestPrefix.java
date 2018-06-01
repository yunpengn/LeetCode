package leetcode;

public class LongestPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0].substring(0, strs[0].length());

        for (String str: strs) {

        }

        return prefix;
    }

    private String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());

        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }

        return left.substring(0, min);
    }
}

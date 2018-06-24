package leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char current = strs[0].charAt(i);

            for (String str : strs) {
                if (str.length() <= i || current != str.charAt(i)) {
                    return str.substring(0, i);
                }
            }
        }

        return strs[0];
    }
}

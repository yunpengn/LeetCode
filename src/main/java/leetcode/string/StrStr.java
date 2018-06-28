package leetcode.string;

public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        for (int i = 0; i < haystack.length(); i++) {
            int m = i;
            int n = 0;
            while (haystack.charAt(m) == needle.charAt(n)) {
                m++;
                n++;

                if (n >= needle.length()) {
                    return i;
                } else if (m >= haystack.length()) {
                    return -1;
                }
            }
        }

        return -1;
    }
}

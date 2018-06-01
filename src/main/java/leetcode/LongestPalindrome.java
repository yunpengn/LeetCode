package leetcode;

public class LongestPalindrome {
    private String str = "";

    // We will try to expand around the center.
    // There are two kinds of centers: when the palindrome is odd and when it is even.
    public String longestPalindrome(String s) {
        str = s;

        // To record the result.
        String result = "";
        int longest = 0;

        // The length of the current palindrome.
        int current = 0;
        // The starting/ending point of the current palindrome.
        int start;
        int end;
        int around;
        int length;

        // We start with those odd ones.
        for (int i = 0; i < s.length(); i++) {
            around = expandAroundOddCenter(i);
            start = i - around;
            end = i + around;
            length = end - start + 1;

            if (length > longest) {
                result = str.substring(start, end + 1);
                longest = length;
            }
        }

        // We continue with those even ones.
        for (int i = 1; i < s.length(); i++) {
            around = expandAroundEvenCenter(i - 1, i);
            start = i - 1 - around;
            end = i + around;
            length = end - start + 1;

            if (length > longest) {
                result = str.substring(start, end + 1);
                longest = length;
            }
        }

        return result;
    }

    private int expandAroundOddCenter(int center) {
        int around = 0;

        while (center - around >= 0 && center + around < str.length()) {
            if (str.charAt(center - around) != str.charAt(center + around)) {
                return around - 1;
            }
            around++;
        }

        return around - 1;
    }

    private int expandAroundEvenCenter(int left, int right) {
        int around = 0;

        while (left - around >= 0 && right + around < str.length()) {
            if (str.charAt(left - around) != str.charAt(right + around)) {
                return around - 1;
            }
            around++;
        }

        return around - 1;
    }
}

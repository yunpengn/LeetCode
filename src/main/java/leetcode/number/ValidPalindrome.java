package leetcode.number;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int first = 0;
        int second = s.length() - 1;
        while (first < second) {
            char firstChar = s.charAt(first);
            char secondChar = s.charAt(second);

            if (!Character.isLetterOrDigit(firstChar)) {
                first++;
            } else if (!Character.isLetterOrDigit(secondChar)) {
                second--;
            } else if (Character.toLowerCase(firstChar) != Character.toLowerCase(secondChar)) {
                return false;
            } else {
                first++;
                second--;
            }
        }

        return true;
    }
}

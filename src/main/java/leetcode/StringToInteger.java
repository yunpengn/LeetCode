package leetcode;

public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        // Removes the whitespaces ahead.
        int startIndex = 0;
        while (str.charAt(startIndex) == 32) {
            startIndex++;

            // Returns 0 when the whole string is whitespaces.
            if (startIndex >= str.length()) {
                return 0;
            }
        }

        // Finds the sign of the number and starting of the numeric part.
        int sign = 0;
        if (str.charAt(startIndex) == 45) {
            sign = -1;
            startIndex++;

            // Returns 0 when the whole string only has a minus sign.
            if (startIndex >= str.length()) {
                return 0;
            }
        } else if (str.charAt(startIndex) == 43) {
            sign = 1;
            startIndex++;

            // Returns 0 when the whole string only has a plus sign.
            if (startIndex >= str.length()) {
                return 0;
            }
        } else if (isNumeric(str.charAt(startIndex))) {
            sign = 1;
        } else {
            return 0;
        }

        // Iterates until meeting the first non-numeric character.
        long result = 0;
        for (int i = startIndex; i < str.length(); i++) {
            if (!isNumeric(str.charAt(i))) {
                break;
            }
            result = result * 10 + toNumber(str.charAt(i));

            if (sign * result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (sign * result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }

        return (int) result * sign;
    }

    private boolean isNumeric(char c) {
        return c>= 48 && c <= 57;
    }

    private int toNumber(char c) {
        return c - 48;
    }
}

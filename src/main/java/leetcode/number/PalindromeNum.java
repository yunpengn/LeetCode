package leetcode.number;

import java.util.ArrayList;
import java.util.List;

class PalindromeNum {
    public boolean isNumericPalindrome(long number) {
        List<Integer> digits = new ArrayList<>();

        while (number > 0) {
            int digit = (int) number % 10;
            digits.add(digit);
            number /= 10;
        }

        int count = digits.size();
        for (int i = 0; i < count / 2; i++) {
            int first = digits.get(i);
            int second = digits.get(count - i - 1);
            if (first != second) {
                return false;
            }
        }

        return true;
    }
}

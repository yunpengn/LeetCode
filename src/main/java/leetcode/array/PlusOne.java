package leetcode.array;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;

        for (int i = digits.length - 1; i >= 0 && carry > 0; i--) {
            int newValue = digits[i] + carry;
            carry = newValue / 10;
            digits[i] = newValue % 10;
        }

        if (carry == 1) {
            int[] number = new int[digits.length + 1];
            number[0] = 1;
            return number;
        } else {
            return digits;
        }
    }
}

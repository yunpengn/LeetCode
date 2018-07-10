package leetcode.string;

public class MultipleStrings {
    private static final int ZERO_OFFSET = 48;

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        } else if (num1.length() == 0 || num2.length() == 0) {
            return "";
        } else if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] numA = toBits(num1);
        int[] numB = toBits(num2);
        int[] bits = new int[numA.length + numB.length];

        for (int i = 0; i < numA.length; i++) {
            for (int j = 0; j < numB.length; j++) {
                int multiple = numA[i] * numB[j];
                bits[i + j] += multiple % 10;
                bits[i + j + 1] += multiple / 10;
            }
        }

        // Makes sure all the padding are correct.
        for (int i = 0; i < bits.length - 1; i++) {
            int value = bits[i];
            if (value >= 10) {
                bits[i + 1] += value / 10;
                bits[i] = value % 10;
            }
        }

        // Drops all the leading zeros.
        int index = bits.length - 1;
        while (bits[index] == 0) {
            index--;
        }

        // Converts into the final result string.
        StringBuilder builder = new StringBuilder();
        for (int i = index; i >= 0; i--) {
            builder.append(toChar(bits[i]));
        }

        return builder.toString();
    }

    private int[] toBits(String input) {
        int length = input.length();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            char bit = input.charAt(length - 1 - i);
            result[i] = Character.getNumericValue(bit);
        }

        return result;
    }

    private char toChar(int digit) {
        return (char) (digit + ZERO_OFFSET);
    }
}

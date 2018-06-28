package leetcode.number;

public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();

        // Deals with the thousand bit.
        if (num >= 1000) {
            for (int i = 0; i < num / 1000; i++) {
                builder.append("M");
            }
            num %= 1000;
        }

        // Deals with the hundred bit.
        if (num >= 100) {
            int bit = num / 100;
            if (bit == 9) {
                builder.append("CM");
            } else if (bit == 4) {
                builder.append("CD");
            } else {
                if (bit >= 5) {
                    builder.append("D");
                    bit -= 5;
                }
                for (int i = 0; i < bit; i++) {
                    builder.append("C");
                }
            }
            num %= 100;
        }

        // Deals with the ten bit.
        if (num >= 10) {
            int bit = num / 10;
            if (bit == 9) {
                builder.append("XC");
            } else if (bit == 4) {
                builder.append("XL");
            } else {
                if (bit >= 5) {
                    builder.append("L");
                    bit -= 5;
                }
                for (int i = 0; i < bit; i++) {
                    builder.append("X");
                }
            }
            num %= 10;
        }

        // Deals with the one bit.
        if (num > 0) {
            if (num == 9) {
                builder.append("IX");
            } else if (num == 4) {
                builder.append("IV");
            } else {
                if (num >= 5) {
                    builder.append("V");
                    num -= 5;
                }
                for (int i = 0; i < num; i++) {
                    builder.append("I");
                }
            }
        }


        return builder.toString();
    }
}

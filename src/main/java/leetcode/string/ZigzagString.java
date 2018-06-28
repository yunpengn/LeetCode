package leetcode.string;

public class ZigzagString {
    public String convert(String s, int numRows) {
        StringBuilder[] zigzag = new StringBuilder[numRows];
        int length = s.length();

        for (int m = 0; m < numRows; m++) {
            zigzag[m] = new StringBuilder();
        }

        int i = 0;
        while (i < length) {
            // Go down
            for (int j = 0; j < numRows && i < length; j++) {
                zigzag[j].append(s.charAt(i));
                i++;
            }

            // Go up (right top).
            for (int k = numRows - 2; k >= 1 && i < length; k--) {
                zigzag[k].append(s.charAt(i));
                i++;
            }
        }

        for (i = 1; i < numRows; i++) {
            zigzag[0].append(zigzag[i]);
        }
        return zigzag[0].toString();
    }
}

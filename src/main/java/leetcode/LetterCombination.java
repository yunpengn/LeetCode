package leetcode;

import java.util.LinkedList;
import java.util.List;

public class LetterCombination {
    private static String[] mapping = new String[10];

    static {
        mapping[2] = "abc";
        mapping[3] = "def";
        mapping[4] = "ghi";
        mapping[5] = "jkl";
        mapping[6] = "mno";
        mapping[7] = "pqrs";
        mapping[8] = "tuv";
        mapping[9] = "wxyz";
    }

    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();

        // Exits first for an empty string.
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        // Iterates through every digit.
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            char current = digits.charAt(i);
            String currentString = mapping[toNumber(current)];

            while (result.getFirst().length() == i) {
                String previous = result.removeFirst();

                for (int j = 0; j < currentString.length(); j++) {
                    result.add(previous + currentString.charAt(j));
                }
            }
        }

        return result;
    }

    private int toNumber(char c) {
        return c - 48;
    }
}

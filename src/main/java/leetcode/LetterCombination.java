package leetcode;

import java.util.ArrayList;
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
        List<String> result = new LinkedList<>();

        return result;
    }
}

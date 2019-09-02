package leetcode.list;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            result.add(new ArrayList<>());

            for (int j = 0; j <= i; j++) {
                int val = 1;
                if (j != 0 && j != i) {
                    val = result.get(i - 1).get(j - 1)
                            + result.get(i - 1).get(j);
                }

                result.get(i).add(val);
            }
        }

        return result;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> lastRow = new ArrayList<>();
        List<Integer> thisRow = null;

        for (int i = 0; i <= rowIndex; i++) {
            lastRow = thisRow;
            thisRow = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                int val = 1;
                if (j != 0 && j != i) {
                    val = lastRow.get(j - 1) + lastRow.get(j);
                }

                thisRow.add(val);
            }
        }

        return thisRow;
    }
}

package leetcode;

import java.util.List;

public class TriangleMinPath {
    /**
     * Tries to find the minimum path sum from top to bottom. However, this method starts
     * from the bottom to achieve time & space optimization.
     *
     * @param triangle is the input triangle "matrix" of numbers.
     * @return the minimum path sum from top to bottom
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int numOfRows = triangle.size();
        // Keeps track of the sum so far for each element in the current row.
        int[] sumSoFar = new int[numOfRows];

        // The sum so far for each element in the last row is the same as the value itself.
        List<Integer> currentRow = triangle.get(numOfRows - 1);
        for (int i = 0; i < numOfRows; i++) {
            sumSoFar[i] = currentRow.get(i);
        }

        // Updates the other rows according to the result from the row below.
        for (int row = numOfRows - 2; row >= 0; row--) {
            currentRow = triangle.get(row);
            for (int column = 0; column <= row; column++) {
                sumSoFar[column] = Math.min(sumSoFar[column], sumSoFar[column + 1]) + currentRow.get(column);
            }
        }

        return sumSoFar[0];
    }
}

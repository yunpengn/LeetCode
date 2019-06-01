package leetcode.matrix;

public class NumMatrix {
    // Stores the sum of the elements in each row in the range of [0, n).
    private final int[][] sumUntil;

    /**
     * Prepares the information required for future calculation.
     *
     * @param matrix is the given matrix.
     */
    public NumMatrix(int[][] matrix) {
        // Initializes the new matrix.
        sumUntil = new int[matrix.length][];

        // Fills in the new matrix row by row.
        for (int i = 0; i < matrix.length; i++) {
            int currentSum = 0;
            sumUntil[i] = new int[matrix[i].length + 1];

            for (int j = 0; j < matrix[i].length; j++) {
                sumUntil[i][j] = currentSum;
                currentSum += matrix[i][j];
            }
            sumUntil[i][matrix[i].length] = currentSum;
        }
    }

    /**
     * Calculates the sum of the elements in the rectangle bounded by the given region.
     *
     * @param row1 is the row index of the top-left corner of the region.
     * @param col1 is the column index of the top-left corner of the region.
     * @param row2 is the row index of the bottom-right corner of the region.
     * @param col2 is the column index of the bottom-right corner of the region.
     * @return the sum of the elements inside the region.
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int i = row1; i <= row2; i++) {
            int currentRow = sumUntil[i][col2 + 1] - sumUntil[i][col1];
            result += currentRow;
        }
        return result;
    }
}

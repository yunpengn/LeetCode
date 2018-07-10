package leetcode.matrix;

public class RotateImage {
    /**
     * A clock-wise 90-degree rotation of a square matrix can be down in two steps:
     * <ul>
     *     <li>Reverse up to down</li>
     *     <li>Swap along the diagonal</li>
     * </ul>
     *
     * @param matrix is the input matrix.
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int numOfColumns = matrix[0].length;
        int numOfRows = matrix.length;

        // First reverse up to down.
        int up = 0;
        int down = numOfRows - 1;
        while (up < down) {
            for (int i = 0; i < numOfColumns; i++) {
                int temp = matrix[up][i];
                matrix[up][i] = matrix[down][i];
                matrix[down][i] = temp;
            }
            
            up++;
            down--;
        }

        // Then swap along the diagonal.
        for (int i = 0; i < numOfRows; i++) {
            for (int j = i; j < numOfColumns; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}

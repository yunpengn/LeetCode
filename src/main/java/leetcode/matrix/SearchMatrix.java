package leetcode.matrix;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        // Starts from the top-right corner.
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            int current = matrix[row][column];
            if (current == target) {
                return true;
            } else if (target < current) {
                column--;
            } else {
                row++;
            }
        }

        return false;
    }
}

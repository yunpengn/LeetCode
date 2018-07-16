package leetcode.matrix;

public class Transpose {
    public int[][] transpose(int[][] A) {
        int row = A.length;
        int column = A[0].length;
        int[][] result = new int[column][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result[j][i] = A[i][j];
            }
        }

        return result;
    }
}

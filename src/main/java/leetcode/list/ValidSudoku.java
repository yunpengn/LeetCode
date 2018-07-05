package leetcode.list;

public class ValidSudoku {
    // Defines a few constants for ASCII code values.
    private static final int NUM_OFFSET = 48;

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9) {
            return false;
        }

        int[][] check1 = new int[9][9];
        int[][] check2 = new int[9][9];
        int[][] check3 = new int[9][9];

        for (int i = 0; i < 9; i++) {
            char[] row = board[i];

            if (row.length != 9) {
                return false;
            }

            for (int j = 0; j < 9; j++) {
                int value = toNumber(row[j]) - 1;

                // Escapes all empty cells.
                if (value < 0 || value > 9) {
                    continue;
                }

                // First checks each row.
                if (check1[i][value] != 0) {
                    return false;
                } else {
                    check1[i][value] = 1;
                }

                // Then checks each column.
                if (check2[j][value] != 0) {
                    return false;
                } else {
                    check2[j][value] = 1;
                }

                // Then checks each sub-box.
                int boxIndex = getSubBoxIndex(i, j);
                if (check3[boxIndex][value] != 0) {
                    return false;
                } else {
                    check3[boxIndex][value] = 1;
                }
            }
        }

        return true;
    }

    private int toNumber(char input) {
        return input - NUM_OFFSET;
    }

    private int getSubBoxIndex(int row, int column) {
        return (row / 3) * 3 + (column / 3);
    }
}

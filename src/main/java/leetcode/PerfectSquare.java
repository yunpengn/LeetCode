package leetcode;

public class PerfectSquare {
    // Makes use of static dynamic programming.
    public int numSquares(int n) {
        // The result from 1 to n.
        int[] squares = new int[n + 1];
        squares[0] = 0;

        // Computes the result from bottom up.
        int resultSoFar;
        for (int current = 1; current <= n; current++) {
            resultSoFar = current;
            for (int j = 1; j * j <= current; j++) {
                resultSoFar = Math.min(resultSoFar, squares[current - j * j] + 1);
            }
            squares[current] = resultSoFar;
        }

        return squares[n];
    }
}

package others;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShopFarm {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reads the # of test cases.
        int T = Integer.parseInt(br.readLine());

        // Goes through each test case.
        for (int i = 0; i < T; i++) {
            // Reads the first line.
            String[] group = br.readLine().split(" ");
            int N = Integer.parseInt(group[0]);
            int M = Integer.parseInt(group[1]);

            // Reads the next N days.
            int[][] values = new int[N][M];
            for (int j = 0; j < N; j++) {
                group = br.readLine().split(" ");

                // Reads value of all cells on this day.
                for (int k = 0; k < M; k++) {
                    values[j][k] = Integer.parseInt(group[k]);
                }
            }

            // Finds the result of current test case.
            final int result = calculate(values, N, M);
            System.out.println(result);
        }
    }

    private static int calculate(int[][] values, int numDays, int numCells) {
        // Each day has 2 results, 1st one beginning on the very left while 2nd one beginning on the very right.
        final int[][] results = new int[numDays][2];

        // Let's first only consider the current day.
        for (int i = numDays - 1; i >= 0; i--) {
            // Let's first consider: #1 starting from left.
            int leftMax = 0;
            int leftSoFar = 0;
            for (int j = 0; j < numCells; j++) {
                leftSoFar += values[i][j];
                if (leftSoFar > leftMax) {
                    leftMax = leftSoFar;
                }
            }

            // Have 3 choices now.
            final int left1 = i + 1 >= numDays ? 0 : results[i + 1][0];
            final int left2 = i + 1 >= numDays ? leftMax : results[i + 1][0] + leftMax;
            final int left3 = i + 1 >= numDays ? leftSoFar : results[i + 1][1] + leftSoFar;
            results[i][0] = Math.max(Math.max(left1, left2), left3);

            // Let's first consider: #2 starting from right.
            int rightMax = 0;
            int rightSoFar = 0;
            for (int j = numCells - 1; j >= 0; j--) {
                rightSoFar += values[i][j];
                if (rightSoFar > rightMax) {
                    rightMax = rightSoFar;
                }
            }

            // Have 3 choices now.
            final int right1 = i + 1 >= numDays ? 0 : results[i + 1][1];
            final int right2 = i + 1 >= numDays ? rightMax : results[i + 1][1] + rightMax;
            final int right3 = i + 1 >= numDays ? rightSoFar : results[i + 1][0] + rightSoFar;
            results[i][1] = Math.max(Math.max(right1, right2), right3);
        }

        // Returns the day 1 result, starting from left.
        return results[0][0];
    }
}

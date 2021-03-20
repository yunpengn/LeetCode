package others;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Divider {
    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reads the first line.
        String[] group = br.readLine().split(" ");
        final int N = Integer.parseInt(group[0]);
        final int K = Integer.parseInt(group[1]);

        // Reads the second line.
        group = br.readLine().split(" ");
        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(group[i]);
        }

        int result = find(values, K - 1, 0, 0, 0, 0);
        System.out.println(result);
    }

    private static int find(int[] values, int K, int index, int soFarCount, int soFarSum, int totalSum) {
        if (K >= values.length - index || K < 0) {
            return Integer.MAX_VALUE;
        }

        int currentGroup = (soFarSum + values[index]) * (soFarCount + 1);
        if (index == values.length - 1) {
            return totalSum + currentGroup;
        }

        int divide = find(values, K - 1, index + 1, 0, 0, totalSum + currentGroup);
        int notDivide = find(values, K, index + 1, soFarCount + 1, soFarSum + values[index], totalSum);
        return Math.min(divide, notDivide);
    }
}

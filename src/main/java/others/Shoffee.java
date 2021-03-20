package others;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Shoffee {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reads the first line.
        String[] group = br.readLine().split(" ");
        int N = Integer.parseInt(group[0]);
        int K = Integer.parseInt(group[1]);

        // Reads the second line.
        group = br.readLine().split(" ");
        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(group[i]);
        }

        // Calculates the result.
        int result = count(values, K, 0, 0, 0);
        System.out.println(result);
    }

    private static int count(int[] values, int K, int index, int soFarCount, int soFarSum) {
        if (index == values.length - 1) {
            return soFarSum + values[index] >= K * (soFarCount + 1) ? 1 : 0;
        }

        int without = count(values, K, index + 1, 0, 0);
        int with = count(values, K, index + 1, soFarCount + 1, soFarSum + values[index]);
        return without + with;
    }
}


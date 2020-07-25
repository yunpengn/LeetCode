package others;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IntersectWiFi {
    public static void main(String[] args) throws Exception {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Gets the number of engineers.
        String line = reader.readLine();
        final int N = Integer.parseInt(line);

        // Reads the location of each engineer.
        final int[][] locations = new int[N][2];
        for (int i = 0; i < N; i++) {
            line = reader.readLine();
            locations[i][0] = Integer.parseInt(line.split(" ")[0]);
            locations[i][1] = Integer.parseInt(line.split(" ")[1]);
        }

        // Reads the location of two APs.
        line = reader.readLine();
        final int x1 = Integer.parseInt(line.split(" ")[0]);
        final int y1 = Integer.parseInt(line.split(" ")[1]);
        final int x2 = Integer.parseInt(line.split(" ")[2]);
        final int y2 = Integer.parseInt(line.split(" ")[3]);

        // Calculates the (square of) distances.
        final long[] distances1 = new long[N];
        final long[] distances2 = new long[N];
        for (int i = 0; i < N; i++) {
            distances1[i] = (locations[i][0] - x1) * (locations[i][0] - x1)
                + (locations[i][1] - y1) * (locations[i][1] - y1);
            distances2[i] = (locations[i][0] - x2) * (locations[i][0] - x2)
                + (locations[i][1] - y2) * (locations[i][1] - y2);
        }

        // Answers queries.
        final int Q = Integer.parseInt(reader.readLine());
        for (int i = 0; i < Q; i++) {
            line = reader.readLine();
            final int r1 = Integer.parseInt(line.split(" ")[0]);
            final int r2 = Integer.parseInt(line.split(" ")[1]);
            final long r1q = r1 * r1;
            final long r2q = r2 * r2;

            // Counts the # of engineers not covered.
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (distances1[j] <= r1q && distances2[j] <= r2q
                    || distances1[j] > r1q && distances2[j] > r2q) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}

package others;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JudgingServer {
    public static void main(String[] args) throws Exception {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Iterates over the number of test cases.
        int cases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < cases; i++) {
            int numOfServers = Integer.parseInt(reader.readLine().split(" ")[1]);
            String[] tokens = reader.readLine().split(" ");

            int[] prices = new int[tokens.length];
            for (int j = 0; j < tokens.length; j++) {
                prices[j] = Integer.parseInt(tokens[j]);
            }

            long[][] cache = new long[prices.length][prices.length];
            for (int j = 0; j < prices.length; j++) {
                for (int k = 0; k < prices.length; k++) {
                    cache[j][k] = -1;
                }
            }

            long result = minCost(prices, cache, numOfServers, 0);
            System.out.printf("Case %d: %d\n", i + 1, result);
        }
    }

    static long minCost(int[] prices, long[][] cache, int numServers, int startIndex) {
        if (numServers == 0) {
            // Returns early if no need to buy any server.
            return 0;
        } else if (startIndex >= prices.length) {
            // Impossible to fulfill the requirement.
            return Integer.MAX_VALUE;
        } else if (cache[startIndex][numServers] != -1) {
            return cache[startIndex][numServers];
        }

        // Choice 1: take current, but do not take the adjacent server.
        long cost1 = minCost(prices, cache, numServers - 1, startIndex + 1)
            + prices[startIndex];

        // Choice 2: take the adjacent server.
        long cost2 = cost1;
        if (startIndex != prices.length - 1 && numServers > 1) {
            cost2 = minCost(prices, cache, numServers - 2, startIndex + 2)
            + Math.min(prices[startIndex], prices[startIndex + 1]);
        }

        // Choice 3: do not take any server.
        long cost3 = minCost(prices, cache, numServers, startIndex + 1);

        // Final result.
        long min = Math.min(Math.min(cost1, cost2), cost3);
        cache[startIndex][numServers] = min;
        return min;
    }
}

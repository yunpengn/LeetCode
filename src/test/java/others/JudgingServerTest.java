package others;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class JudgingServerTest {
    @Test void test1() {
        final int[] prices = new int[]{15, 14, 15};

        final long[][] cache = new long[prices.length][prices.length];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cache[i][j] = -1;
            }
        }

        long cost = JudgingServer.minCost(prices, cache, 2, 0);
        assertEquals(14, cost);
    }

    @Test void test2() {
        final int[] prices = new int[]{1000, 560, 30, 85, 100};

        final long[][] cache = new long[prices.length][prices.length];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                cache[i][j] = -1;
            }
        }

        long cost = JudgingServer.minCost(prices, cache, 3, 0);
        assertEquals(115, cost);
    }
}

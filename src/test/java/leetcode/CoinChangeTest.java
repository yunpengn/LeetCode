package leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoinChangeTest {
    private static final CoinChange tester = new CoinChange();

    @Test
    void simpleTest1() {
        int[] coins = new int[] { 1, 2, 5 };
        assertEquals(3, tester.coinChange(coins, 11));
    }

    @Test
    void simpleTest2() {
        int[] coins = new int[] { 2 };
        assertEquals(-1, tester.coinChange(coins, 3));
    }
}

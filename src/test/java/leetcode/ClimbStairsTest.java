package leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class ClimbStairsTest {
    private static final ClimbStairs tester = new ClimbStairs();

    @Test
    void simpleTest() {
        int[] expected = new int[]{ 1, 1, 2, 3, 5 };
        int[] result = new int[expected.length];

        for (int i = 0; i < expected.length; i++) {
            result[i] = tester.climbStairs(i);
        }
        assertArrayEquals(expected, result);
    }
}
package leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PerfectSquareTest {
    private PerfectSquare tester = new PerfectSquare();

    @Test
    void simpleTest() {
        assertEquals(3, tester.numSquares(12), "The result is wrong.");
    }
}

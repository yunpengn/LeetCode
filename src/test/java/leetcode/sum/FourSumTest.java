package leetcode.sum;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class FourSumTest {
    private static final FourSum tester = new FourSum();

    @Test
    public void simpleTest() {
        assertEquals(new LinkedList<>(), tester.fourSum(new int[]{ 0, 0, 0, 0 }, 1));
    }
}

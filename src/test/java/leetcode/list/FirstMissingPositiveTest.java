package leetcode.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FirstMissingPositiveTest {
    private static final FirstMissingPositive tester = new FirstMissingPositive();

    @Test
    void simpleTest() {
        int[] input = new int[]{ 3, 4, -1, 1 };
        assertEquals(2, tester.firstMissingPositive(input));
    }
}

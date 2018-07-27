package leetcode.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SortColorsTest {
    private static final SortColors tester = new SortColors();

    @Test
    void simpleTest() {
        int[] input = new int[]{ 2, 0, 2, 1, 1, 0 };
        int[] expected = new int[]{ 0, 0, 1, 1, 2, 2 };

        tester.sortColors(input);
        assertArrayEquals(expected, input);
    }
}
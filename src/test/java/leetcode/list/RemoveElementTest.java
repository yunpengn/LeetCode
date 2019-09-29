package leetcode.list;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import leetcode.array.RemoveElement;

class RemoveElementTest {
    private static final RemoveElement tester = new RemoveElement();

    @Test
    public void simpleTest() {
        int[] input = new int[]{ 3, 2, 2, 3 };
        int[] expected = new int[] { 2, 2, 3, 3 };

        assertEquals(2, tester.removeElement(input, 3));
        assertArrayEquals(expected, input, "The result is wrong.");
    }
}

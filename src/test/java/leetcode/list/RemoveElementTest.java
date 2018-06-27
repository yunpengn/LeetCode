package leetcode.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RemoveElementTest {
    private static final RemoveElement tester = new RemoveElement();

    @Test
    public void simpleTest() {
        int[] input = new int[]{ 3, 2, 2, 3 };
        int[] expected = new int[] { 2, 2, 3, 3 };

        tester.removeElement(input, 3);
        assertEquals(expected, input, "The result is wrong.");
    }
}
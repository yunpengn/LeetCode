package leetcode.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NextPermutationTest {
    private static final NextPermutation tester = new NextPermutation();

    @Test
    void simpleTest1() {
        int[] input = new int[]{ 1, 2, 3 };
        int[] expected = new int[]{ 1, 3, 2 };

        tester.nextPermutation(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void simpleTest2() {
        int[] input = new int[]{ 3, 2, 1 };
        int[] expected = new int[]{ 1, 2, 3 };

        tester.nextPermutation(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void simpleTest3() {
        int[] input = new int[]{ 1, 1, 5 };
        int[] expected = new int[]{ 1, 5, 1 };

        tester.nextPermutation(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void simpleTest4() {
        int[] input = new int[]{ 1, 3, 2 };
        int[] expected = new int[]{ 2, 1, 3 };

        tester.nextPermutation(input);
        assertArrayEquals(expected, input);
    }
}

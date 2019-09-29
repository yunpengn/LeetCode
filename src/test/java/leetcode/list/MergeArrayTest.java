package leetcode.list;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import leetcode.array.MergeArray;

class MergeArrayTest {
    private static final MergeArray tester = new MergeArray();

    @Test
    void test1() {
        int[] arr1 = new int[]{ 1, 2, 3, 0, 0, 0 };
        int[] arr2 = new int[]{ 2, 5, 6 };
        tester.merge(arr1, 3, arr2, 3);

        int[] expected = new int[]{ 1, 2, 2, 3, 5, 6 };
        assertArrayEquals(expected, arr1);
    }

    @Test
    void test2() {
        int[] arr1 = new int[]{ 4, 5, 6, 0, 0, 0 };
        int[] arr2 = new int[]{ 1, 2, 3 };
        tester.merge(arr1, 3, arr2, 3);

        int[] expected = new int[]{ 1, 2, 3, 4, 5, 6 };
        assertArrayEquals(expected, arr1);
    }
}

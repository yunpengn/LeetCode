package others;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BinarySortTest {
    @Test
    void test1() {
        int[] input = new int[]{ 1, 0, 0, 1, 1, 0, 0, 1 };
        assertEquals(2, BinarySort.moves(input));
    }

    @Test
    void test2() {
        int[] input = new int[]{ 0, 0, 0, 0, 0, 0, 0, 1 };
        assertEquals(0, BinarySort.moves(input));
    }

    @Test
    void test3() {
        int[] input = new int[]{ 1, 3, 4, 5 };
        assertEquals(1, BinarySort.moves(input));
    }

    @Test
    void test4() {
        int[] input = new int[]{ 14, 12, 1, 5 };
        assertEquals(0, BinarySort.moves(input));
    }

    @Test
    void test5() {
        int[] input = new int[]{ 8, 5, 16, 3 };
        assertEquals(1, BinarySort.moves(input));
    }

    @Test
    void test6() {
        int[] input = new int[]{ 1, 3, 4, 5, 6, 7, 8 };
        assertEquals(2, BinarySort.moves(input));
    }
}

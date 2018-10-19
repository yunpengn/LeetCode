package others;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IdleGameTest {
    @Test
    void test1() {
        int[] values = new int[]{ 2, 4, 9 };
        int[] costs  = new int[]{ 0, 5, 8 };
        assertEquals(6, IdleGame.calculateMinimum(2, 15, values, costs));
    }

    @Test
    void test2() {
        int[] values = new int[]{ 1, 5, 10 };
        int[] costs  = new int[]{ 0, 1, 5 };
        assertEquals(5, IdleGame.calculateMinimum(2, 30, values, costs));
    }

    @Test
    void test3() {
        int[] values = new int[]{ 1 };
        int[] costs  = new int[]{ 0 };
        assertEquals(10, IdleGame.calculateMinimum(0, 10, values, costs));
    }

    @Test
    void test4() {
        int[] values = new int[]{ 10 };
        int[] costs  = new int[]{ 0 };
        assertEquals(1, IdleGame.calculateMinimum(0, 10, values, costs));
    }

    @Test
    void test5() {
        int[] values = new int[]{ 12 };
        int[] costs  = new int[]{ 0 };
        assertEquals(1, IdleGame.calculateMinimum(0, 10, values, costs));
    }

    @Test
    void test6() {
        int[] values = new int[]{ 12, 15 };
        int[] costs  = new int[]{ 0, 2 };
        assertEquals(1, IdleGame.calculateMinimum(1, 10, values, costs));
    }

    @Test
    void test7() {
        int[] values = new int[]{ 1, 6, 9, 10 };
        int[] costs  = new int[]{ 0, 1, 4, 8 };
        assertEquals(5, IdleGame.calculateMinimum(3, 28, values, costs));
    }

    @Test
    void test8() {
        int[] values = new int[]{ 1, 4, 5, 10 };
        int[] costs  = new int[]{ 0, 2, 3, 5 };
        assertEquals(5, IdleGame.calculateMinimum(3, 13, values, costs));
    }

    @Test
    void test9() {
        int[] values = new int[]{ 1, 5, 10, 12 };
        int[] costs  = new int[]{ 0, 1, 2, 3 };
        assertEquals(3, IdleGame.calculateMinimum(3, 14, values, costs));
    }

    @Test
    void test10() {
        int[] values = new int[]{ 1, 3, 4, 8 };
        int[] costs  = new int[]{ 0, 1, 3, 4 };
        assertEquals(4, IdleGame.calculateMinimum(3, 10, values, costs));
    }

    @Test
    void test11() {
        int[] values = new int[]{ 1, 2, 3, 7 };
        int[] costs  = new int[]{ 0, 1, 2, 3 };
        assertEquals(4, IdleGame.calculateMinimum(3, 8, values, costs));
    }
}

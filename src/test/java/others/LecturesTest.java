package others;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LecturesTest {
    private static final Lectures tester = new Lectures();

    @Test
    void test1() {
        int[] start = new int[]{ 3, 5, 4, 2, 1 };
        int[] end = new int[]{ 4, 6, 7, 5, 5 };
        assertEquals(3, tester.calculateMinimumHalls(start.length, start, end));
        assertEquals(1, tester.calculateMinimumCancels(start.length, 2, start, end));
    }

    @Test
    void test2() {
        int[] start = new int[]{ 2, 4, 3, 5, 1 };
        int[] end = new int[]{ 3, 5, 4, 6, 2 };
        assertEquals(1, tester.calculateMinimumHalls(start.length, start, end));
        assertEquals(0, tester.calculateMinimumCancels(start.length, 2, start, end));
    }
}

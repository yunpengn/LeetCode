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
//        assertEquals(3, tester.calculateMinimumCancels(start.length, 2, start, end));
    }
}

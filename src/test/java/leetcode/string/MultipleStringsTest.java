package leetcode.string;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MultipleStringsTest {
    private static final MultipleStrings tester = new MultipleStrings();

    @Test
    void simpleTest1() {
        String output = "156";
        assertEquals(output, tester.multiply("12", "13"));
    }

    @Test
    void simpleTest2() {
        String output = "72";
        assertEquals(output, tester.multiply("9", "8"));
    }

    @Test
    void simpleTest3() {
        String output = "8";
        assertEquals(output, tester.multiply("2", "4"));
    }

    @Test
    void simpleTest4() {
        String output = "998001";
        assertEquals(output, tester.multiply("999", "999"));
    }

    @Test
    void simpleTest5() {
        String output = "2040";
        assertEquals(output, tester.multiply("5", "408"));
    }
}

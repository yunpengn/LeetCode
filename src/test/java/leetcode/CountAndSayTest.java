package leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CountAndSayTest {
    private static final CountAndSay tester = new CountAndSay();

    @Test
    void simpleTest1() {
        assertEquals("1", tester.countAndSay(1));
    }

    @Test
    void simpleTest2() {
        assertEquals("11", tester.countAndSay(2));
    }

    @Test
    void simpleTest3() {
        assertEquals("21", tester.countAndSay(3));
    }

    @Test
    void simpleTest4() {
        assertEquals("1211", tester.countAndSay(4));
    }
}

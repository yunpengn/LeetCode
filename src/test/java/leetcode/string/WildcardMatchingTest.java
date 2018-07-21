package leetcode.string;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WildcardMatchingTest {
    private static final WildcardMatching tester = new WildcardMatching();

    @Test
    void test1() {
        assertFalse(tester.isMatch("aa", "a"));
    }

    @Test
    void test2() {
        assertTrue(tester.isMatch("aa", "*"));
    }

    @Test
    void test3() {
        assertTrue(tester.isMatch("cb", "?b"));
    }

    @Test
    void test4() {
        assertFalse(tester.isMatch("cb", "?a"));
    }

    @Test
    void test5() {
        assertTrue(tester.isMatch("cbb", "c*"));
    }

    @Test
    void test6() {
        assertTrue(tester.isMatch("cb", "c*"));
    }

    @Test
    void test7() {
        assertTrue(tester.isMatch("cb", "c*"));
    }

    @Test
    void test8() {
        assertTrue(tester.isMatch("adceb", "*a*b"));
    }

    @Test
    void test9() {
        assertTrue(tester.isMatch("aa", "*a"));
    }

    @Test
    void test10() {
        assertTrue(tester.isMatch("a", "*a"));
    }

    @Test
    void test11() {
        assertFalse(tester.isMatch("acdcb", "a*c?b"));
    }
}

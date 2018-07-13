package leetcode.string;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RegexTest {
    private static final Regex tester = new Regex();

    @Test
    void test1() {
        assertTrue(tester.isMatch("ab", ".*"));
    }

    @Test
    void test2() {
        assertTrue(tester.isMatch("aab", "c*a*b"));
    }

    @Test
    void test3() {
        assertFalse(tester.isMatch("a", "ab*a"));
    }

    @Test
    void test4() {
        assertTrue(tester.isMatch("aaa", "ab*a*c*a"));
    }

    @Test
    void test5() {
        assertTrue(tester.isMatch("aaa", "a*a"));
    }

    @Test
    void test6() {
        assertTrue(tester.isMatch("abbc", "ab*bc"));
    }

    @Test
    void test7() {
        assertTrue(tester.isMatch("abbc", "ab*bbc"));
    }

    @Test
    void test8() {
        assertFalse(tester.isMatch("abbc", "ab*bbbc"));
    }

    @Test
    void test9() {
        assertFalse(tester.isMatch("ab", ".*c"));
    }

    @Test
    void test10() {
        assertTrue(tester.isMatch("a", "ab*"));
    }

    @Test
    void test11() {
        assertTrue(tester.isMatch("bbbba", ".*a*a"));
    }
}

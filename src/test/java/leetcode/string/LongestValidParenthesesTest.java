package leetcode.string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LongestValidParenthesesTest {
    private static final LongestValidParentheses tester = new LongestValidParentheses();

    @Test
    void simpleTest1() {
        assertEquals(2, tester.longestValidParentheses("(()"));
    }

    @Test
    void simpleTest2() {
        assertEquals(4, tester.longestValidParentheses(")()())"));
    }

    @Test
    void simpleTest3() {
        assertEquals(0, tester.longestValidParentheses(""));
    }

    @Test
    void simpleTest4() {
        assertEquals(6, tester.longestValidParentheses("(())())"));
    }

    @Test
    void simpleTest5() {
        assertEquals(2, tester.longestValidParentheses("())(()"));
    }

    @Test
    void simpleTest6() {
        assertEquals(2, tester.longestValidParentheses("()(()"));
    }

    @Test
    void simpleTest7() {
        assertEquals(4, tester.longestValidParentheses("()()"));
    }
}

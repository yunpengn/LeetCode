package leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import leetcode.string.ValidParentheses;

class ValidParenthesesTest {
    private static final ValidParentheses tester = new ValidParentheses();

    @Test
    void simpleTest() {
        assertTrue(tester.isValid("()"), "The result is wrong.");
        assertTrue(tester.isValid("([])"), "The result is wrong.");
        assertFalse(tester.isValid("([)]"), "The result is wrong.");
    }
}

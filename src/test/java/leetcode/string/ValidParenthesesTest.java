package leetcode.string;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidParenthesesTest {
    private static final ValidParentheses tester = new ValidParentheses();

    @Test
    void simpleTest() {
        assertTrue(tester.isValid("()"), "The result is wrong.");
        assertTrue(tester.isValid("([])"), "The result is wrong.");
        assertFalse(tester.isValid("([)]"), "The result is wrong.");
    }
}

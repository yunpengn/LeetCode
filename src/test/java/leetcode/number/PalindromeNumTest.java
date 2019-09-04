package leetcode.number;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PalindromeNumTest {
    private PalindromeNum tester = new PalindromeNum();

    @Test
    void simpleTest() {
        assertTrue(tester.isNumericPalindrome(0));
        assertTrue(tester.isNumericPalindrome(1));
        assertTrue(tester.isNumericPalindrome(44));
        assertTrue(tester.isNumericPalindrome(696));

        assertFalse(tester.isNumericPalindrome(17));
        assertFalse(tester.isNumericPalindrome(831));
    }
}

package leetcode.string;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RegexTest {
    private static final Regex tester = new Regex();

    @Test
    void test1() {
        assertTrue(tester.isMatch("ab", ".*"));
    }

//    @Test
//    void test2() {
//        assertTrue(tester.isMatch("aab", "c*a*b"));
//    }
}

package leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReachNumberTest {
    private static final ReachNumber tester = new ReachNumber();

    @Test
    void reachNumber() {
        assertEquals(2, tester.reachNumber(3), "The result is wrong.");
        assertEquals(7, tester.reachNumber(12), "The result is wrong.");
    }
}

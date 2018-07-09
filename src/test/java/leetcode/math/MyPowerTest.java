package leetcode.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import leetcode.math.MyPower;

class MyPowerTest {
    // An instance of BinarySearch to be tested.
    private MyPower tester = new MyPower();
    // The random number generator.
    private static Random generator = new Random();
    // The bound for the range of input data.
    private static int BASE_BOUND = 100;
    private static int POWER_BOUND = 20;
    private static int POWER_BOUND_OFFSET = -POWER_BOUND / 2;

    @Test
    void simpleTest() {
        double base = 2;
        int power = 10;
        assertEquals(Math.pow(base, power), tester.myPow(base, power), "The result is wrong.");

        base = 3;
        power = 11;
        assertEquals(Math.pow(base, power), tester.myPow(base, power), "The result is wrong.");

        base = 3;
        power = -7;
        assertEquals(Math.pow(base, power), tester.myPow(base, power), "The result is wrong.");

        base = 1;
        power = Integer.MIN_VALUE;
        assertEquals(Math.pow(base, power), tester.myPow(base, power), "The result is wrong.");

        base = 2;
        power = Integer.MIN_VALUE;
        assertEquals(Math.pow(base, power), tester.myPow(base, power), "The result is wrong.");

        base = -1;
        power = Integer.MIN_VALUE;
        assertEquals(Math.pow(base, power), tester.myPow(base, power), "The result is wrong.");
    }

    @RepeatedTest(30)
    void myPow() {
        double base = generator.nextDouble() * BASE_BOUND;
        int power = generator.nextInt(POWER_BOUND) + POWER_BOUND_OFFSET;
        assertEquals((int) Math.pow(base, power), (int) tester.myPow(base, power), "The result is wrong.");
    }
}
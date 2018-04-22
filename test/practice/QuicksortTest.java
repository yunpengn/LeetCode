package practice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

class QuicksortTest {
    // The class to be tested.
    private static Quicksort tester = new Quicksort();
    // The random number generator.
    private static Random generator = new Random();

    @Test
    void simpleData() {
        int[] input = new int[] {3, 5, 7, -2, 4, 6, 1};
        int[] result = new int[] {-2, 1, 3, 4, 5, 6, 7};
        tester.sort(input);
        assertArrayEquals(result, input, "The 1st sorting result is wrong.");

        input = new int[] {1, 1, 1, 1, 1};
        result = new int[] {1, 1, 1, 1, 1};
        tester.sort(input);
        assertArrayEquals(result, input, "The 2nd sorting result is wrong.");
    }

    private int[] generateRandomArray(int size) {
        return IntStream.generate(generator::nextInt).limit(size).toArray();
    }
}
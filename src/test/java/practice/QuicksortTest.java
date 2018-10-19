package practice;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class QuicksortTest {
    // The class to be tested.
    private static Quicksort tester = new Quicksort();
    // The random number generator.
    private static Random generator = new Random();
    // The bound for the length of input data.
    private static int INPUT_LENGTH_BOUND = 1000000;

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

        input = new int[] {};
        result = new int[] {};
        tester.sort(input);
        assertArrayEquals(result, input, "The 3rd sorting result is wrong.");

        input = new int[] {1};
        result = new int[] {1};
        tester.sort(input);
        assertArrayEquals(result, input, "The 3rd sorting result is wrong.");

        input = new int[] {3, 2, 1};
        result = new int[] {1, 2, 3};
        tester.sort(input);
        assertArrayEquals(result, input, "The 3rd sorting result is wrong.");
    }

    @RepeatedTest(30)
    void randomData() {
        int[] input = null;
        int[] result = null;

        input = generateRandomArray();
        result = new int[input.length];
        System.arraycopy(input, 0, result, 0, input.length);
        Arrays.sort(result);
        tester.sort(input);
        assertArrayEquals(result, input, "The sorting result is wrong.");
    }

    private int[] generateRandomArray() {
        return generateRandomArray(generator.nextInt(INPUT_LENGTH_BOUND));
    }

    private int[] generateRandomArray(int size) {
        return IntStream.generate(generator::nextInt).limit(size).toArray();
    }
}
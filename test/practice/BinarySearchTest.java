package practice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTest {
    // An instance of BinarySearch to be tested.
    private BinarySearch tester = new BinarySearch();
    // The input data used to test.
    private static List<int[]> inputs = new ArrayList<>();
    // The targets to be searched for.
    private static List<Integer> targets = new ArrayList<>();
    // The expected results (a pair of first occurrence + last occurrence).
    private static List<int[]> results = new ArrayList<>();

    @BeforeAll
    private static void init() {
        inputs.add(new int[] {1, 2, 3});
        targets.add(2);
        results.add(new int[]{1, 1});

        inputs.add(new int[] {1, 2, 3});
        targets.add(3);
        results.add(new int[]{2, 2});

        inputs.add(new int[] {1, 2, 3});
        targets.add(1);
        results.add(new int[]{0, 0});

        inputs.add(new int[] {1, 2, 3});
        targets.add(4);
        results.add(new int[]{-1, -1});

        inputs.add(new int[] {1, 1, 1, 1});
        targets.add(1);
        results.add(new int[]{0, 3});

        inputs.add(new int[] {});
        targets.add(2);
        results.add(new int[]{-1, -1});

        inputs.add(new int[] {3, 4, 5, 6, 8, 9, 19, 20, 45, 87, 193, 5678});
        targets.add(20);
        results.add(new int[]{7, 7});

        inputs.add(new int[] {3, 4, 6, 9, 20, 20, 20, 87, 193, 5678});
        targets.add(20);
        results.add(new int[]{4, 6});

        assertEquals(inputs.size(), targets.size(),
                "The number of groups of input data is different from the number of targets.");
        assertEquals(inputs.size(), results.size(),
                "The number of groups of input data is different from the number of expected results.");
    }

    @Test
    void searchFirstRecursive() {
        for (int i = 0; i < inputs.size(); i++) {
            int result = tester.searchFirstRecursive(inputs.get(i), targets.get(i));
            assertEquals(results.get(i)[0], result, "The searching result is wrong.");
        }
    }

    @Test
    void searchFirstIterative() {
        for (int i = 0; i < inputs.size(); i++) {
            int result = tester.searchFirstIterative(inputs.get(i), targets.get(i));
            assertEquals(results.get(i)[0], result, "The searching result is wrong.");
        }
    }

    @Test
    void searchLastRecursive() {
        for (int i = 0; i < inputs.size(); i++) {
            int result = tester.searchLastRecursive(inputs.get(i), targets.get(i));
            assertEquals(results.get(i)[1], result, "The searching result is wrong.");
        }
    }

    @Test
    void searchLastIterative() {
        for (int i = 0; i < inputs.size(); i++) {
            int result = tester.searchLastIterative(inputs.get(i), targets.get(i));
            assertEquals(results.get(i)[1], result, "The searching result is wrong.");
        }
    }
}

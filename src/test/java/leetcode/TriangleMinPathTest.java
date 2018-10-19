package leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class TriangleMinPathTest {
    // An instance of `TriangleMinPath` to test.
    TriangleMinPath tester = new TriangleMinPath();

    @Test
    void simpleTest() {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(2));
        input.add(Arrays.asList(3, 4));
        input.add(Arrays.asList(6, 5, 7));
        input.add(Arrays.asList(4, 1, 8, 3));

        assertEquals(11, tester.minimumTotal(input), "The result is wrong.");
    }
}
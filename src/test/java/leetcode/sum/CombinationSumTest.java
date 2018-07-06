package leetcode.sum;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class CombinationSumTest {
    private static final CombinationSum tester = new CombinationSum();

    @Test
    void simpleTest() {
        int[] input = new int[]{ 2, 3, 6, 7 };
        List<List<Integer>> output = Collections.singletonList(Collections.singletonList(3));
        assertEquals(tester.combinationSum(input, 3).size(), output.size());

        output = Arrays.asList(Arrays.asList(2, 2, 3), Collections.singletonList(7));
        assertEquals(tester.combinationSum(input, 7).size(), output.size());
    }
}

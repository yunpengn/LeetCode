package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // Uses this to store the result.
        List<List<Integer>> result = new ArrayList<>();

        // Exits prematurely if there are less than three elements.
        if (nums.length < 3) {
            return result;
        }

        // Sorting will not affect the overall time complexity since the lower bound should
        // at least be about O(n^2).
        Arrays.sort(nums);

        // A mapping from all numbers to its respective index.
        Map<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!numbers.containsKey(nums[i])) {
                numbers.put(nums[i], i);
            }
        }

        // Iterates through the array.
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int num1 = nums[i];
                int num2 = nums[j];
                int num3 = -num1 - num2;
                if (numbers.containsKey(num3) && numbers.get(num3) > j) {
                    result.add(Arrays.asList(num1, num2, num3));
                }
            }
        }

        return result;
    }
}

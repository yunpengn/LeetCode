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
        // Defines four temporary variables.
        int num1;
        int num2;
        int num3;
        int sum;

        // Exits prematurely if there are less than three elements.
        if (nums.length < 3) {
            return result;
        }

        // Sorting will not affect the overall time complexity since the lower bound should
        // at least be about O(n^2).
        Arrays.sort(nums);

        // Iterates through the array.
        for (int i = 0; i < nums.length - 2; i++) {
            num1 = nums[i];
            // Avoids duplicate results.
            if (i > 0 && num1 == nums[i - 1]) {
                continue;
            }

            // Uses a two-pointer linear sweep algorithm, which is inspired by interval scheduling
            // (see MIT6.046J Spring 2015 Lecture 1).
            int j = i + 1;
            int k = nums.length - 1;
            // The algorithm is correct since the array has been sorted.
            while (j < k) {
                num2 = nums[j];
                num3 = nums[k];
                sum = num1 + num2 + num3;

                if (sum == 0) {
                    result.add(Arrays.asList(num1, num2, num3));
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }
}

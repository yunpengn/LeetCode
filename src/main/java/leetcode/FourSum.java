package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();

        // Defines four temporary variables.
        int num1;
        int num2;
        int num3;
        int num4;
        int sum;

        // Exits prematurely if there are less than three elements.
        if (nums.length < 4) {
            return result;
        }

        // Sorting will not affect the overall time complexity since the lower bound should
        // at least be about O(n^3).
        Arrays.sort(nums);

        // Iterates through the array.
        for (int i = 0; i < nums.length - 3; i++) {
            num1 = nums[i];
            // Avoids duplicate results.
            if (i > 0 && num1 == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                num2 = nums[j];
                // Avoids duplicate results.
                if (j > i + 1 && num2 == nums[j - 1]) {
                    continue;
                }

                // Uses a two-pointer linear sweep algorithm, which is inspired by interval scheduling
                // (see MIT6.046J Spring 2015 Lecture 1).
                int m = j + 1;
                int n = nums.length - 1;
                // The algorithm is correct since the array has been sorted.
                while (m < nums.length && m < n) {
                    num3 = nums[m];
                    num4 = nums[n];
                    sum = num1 + num2 + num3 + num4;

                    if (sum == target) {
                        result.add(Arrays.asList(num1, num2, num3, num4));
                        do {
                            m++;
                            n--;
                        } while (m < nums.length && m < n && nums[m] == num2 && nums[n] == num3);
                    } else if (sum < target) {
                        m++;
                    } else {
                        n--;
                    }
                }
            }
        }

        return result;
    }
}

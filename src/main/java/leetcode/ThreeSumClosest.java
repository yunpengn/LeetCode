package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        // Exits prematurely if there are less than three elements.
        if (nums.length < 3) {
            return -1;
        }

        // The pre-defined result.
        int result = nums[0] + nums[1] + nums[2];
        // Defines four temporary variables.
        int num1;
        int num2;
        int num3;
        int sum;

        // Sorting will not affect the overall time complexity since the lower bound should
        // at least be about O(n^2).
        Arrays.sort(nums);

        // Iterates through the array.
        for (int i = 0; i < nums.length - 2; i++) {
            num1 = nums[i];

            // Uses a two-pointer linear sweep algorithm, which is inspired by interval scheduling
            // (see MIT6.046J Spring 2015 Lecture 1).
            int j = i + 1;
            int k = nums.length - 1;
            // The algorithm is correct since the array has been sorted.
            while (j < nums.length && j < k) {
                num2 = nums[j];
                num3 = nums[k];
                sum = num1 + num2 + num3;

                if (sum == target) {
                    return target;
                } else {
                    if (Math.abs(sum - target) < Math.abs(result - target)) {
                        result = sum;
                    }

                    if (sum < target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }

        return result;
    }
}

package leetcode.sum;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // A mapping from the value to its index.
        HashMap<Integer, Integer> mapping = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            mapping.put(nums[i], i);
        }

        for (int j = 0; j < nums.length; j++) {
            int other = target - nums[j];
            if (mapping.containsKey(other) && mapping.get(other) != j) {
                result[0] = j;
                result[1] = mapping.get(other);
                break;
            }
        }

        return result;
    }

    public int[] twoSum2(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }

        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                return new int[]{start + 1, end + 1};
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }

        return null;
    }
}

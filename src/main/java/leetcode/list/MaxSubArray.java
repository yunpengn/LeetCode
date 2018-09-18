package leetcode.list;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            maxSum = Math.max(currentSum, maxSum);

            // Ignores the previous part when currentSum < 0.
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }
}

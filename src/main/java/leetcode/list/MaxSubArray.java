package leetcode.list;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Makes use of dynamics programming, record[n] means the sub-array [m, n]
        // that has the largest sum.
        int[] record = new int[nums.length];
        record[0] = nums[0];

        // Takes note of the best result so far.
        int soFar = record[0];

        for (int i = 1; i < nums.length; i++) {
            record[i] = nums[i] + Math.max(record[i - 1], 0);
            soFar = Math.max(soFar, record[i]);
        }

        return soFar;
    }
}

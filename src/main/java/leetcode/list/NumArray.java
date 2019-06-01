package leetcode.list;

public class NumArray {
    // Uses an array to record down the sum from the start of the array until a certain point, such
    // that sumUntil[n] is the sum of the elements in the range of [0, n).
    private final int[] sumUntil;

    /**
     * Constructs the necessary information when given an input array.
     *
     * @param nums is the input array.
     */
    public NumArray(int[] nums) {
        // Initializes the array.
        sumUntil = new int[nums.length + 1];

        // Fills in the array.
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sumUntil[i] = currentSum;
            currentSum += nums[i];
        }
        sumUntil[nums.length] = currentSum;
    }

    /**
     * Calculates the sum of the items in the range of [i, j] (both inclusive).
     *
     * @param i is the start index of the range.
     * @param j is the end index of the range.
     * @return the sum of the elements in the given range.
     */
    public int sumRange(int i, int j) {
        return sumUntil[j + 1] - sumUntil[i];
    }
}

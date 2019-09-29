package leetcode.array;

public class SortColors {
    public void sortColors(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        // Uses two-pointer approach to separate the 3 regions.
        int front = 0;
        int end = nums.length - 1;

        for (int i = 0; i <= end; i++) {
            while (i < end && nums[i] == 2) {
                swap(nums, end, i);
                end--;
            }

            while (i > front && nums[i] == 0) {
                swap(nums, front, i);
                front++;
            }
        }
    }

    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}

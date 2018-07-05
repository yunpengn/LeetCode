package leetcode.list;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // No need to change anything for corner cases.
        if (nums == null || nums.length <= 1) {
            return;
        }

        if (isDescending(nums)) {
            reverse(nums);
        } else {
            // Swaps the last two elements.
            int temp = nums[nums.length - 2];
            nums[nums.length - 2] = nums[nums.length - 1];
            nums[nums.length - 1] = temp;
        }
    }

    // Checks whether the array is descending (not necessarily strictly).
    private boolean isDescending(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                return false;
            }
        }

        return true;
    }

    // Reverses the whole array.
    private void reverse(int[] nums) {
        int front = 0;
        int back = nums.length - 1;

        while (front < back) {
            int temp = nums[front];
            nums[back] = nums[front];
            nums[front] = temp;

            front++;
            back--;
        }
    }
}

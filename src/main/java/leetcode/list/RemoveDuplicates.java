package leetcode.list;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Defines two pointers to store indices.
        int fast = 1;
        int slow = 1;

        while (slow < nums.length) {
            while (fast < nums.length && nums[fast] <= nums[slow - 1]) {
                fast++;
            }

            if (fast >= nums.length) {
                return slow;
            }

            swap(nums, slow, fast);
            slow++;
        }

        return slow;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

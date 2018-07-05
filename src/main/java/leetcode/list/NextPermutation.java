package leetcode.list;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // No need to change anything for corner cases.
        if (nums == null || nums.length <= 1) {
            return;
        }

        int descendFrom = isDescendingFrom(nums);
        if (descendFrom == -1) {
            // Special case: when the whole array is reversely sorted (the highest value),
            // we have to reverse it.
            reverse(nums);
        } else {
            insertFrom(nums, descendFrom);
        }
    }

    // From which to the end is the array descending.
    private int isDescendingFrom(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                return i - 1;
            }
        }

        return -1;
    }

    // Inserts the last element at a certain index and push the else elements.
    private void insertFrom(int[] nums, int start) {
        int last = nums[nums.length - 1];

        for (int i = nums.length - 1; i > start; i--) {
            nums[i] = nums[i - 1];
        }

        nums[start] = last;
    }

    // Reverses the whole array.
    private void reverse(int[] nums) {
        int front = 0;
        int back = nums.length - 1;

        while (front < back) {
            int temp = nums[front];
            nums[front] = nums[back];
            nums[back] = temp;

            front++;
            back--;
        }
    }
}

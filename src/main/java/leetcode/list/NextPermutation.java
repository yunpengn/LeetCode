package leetcode.list;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // No need to change anything for corner cases.
        if (nums == null || nums.length <= 1) {
            return;
        }

        // From which element the array starts to descend. Notice that the part after this
        // index is reversely sorted.
        int descendFrom = isDescendingFrom(nums);

        if (descendFrom == -1) {
            // Special case: when the whole array is reversely sorted (the highest value),
            // we have to reverseFrom it.
            reverseFrom(nums, 0);
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
        // Avoids the possible duplicates and makes the "smallest"
        int current = nums.length - 1;
        while (nums[current] <= nums[start]) {
            current--;
        }

        // Swaps these two elements to get the "next" petmutation.
        swap(nums, start, current);

        // Makes sure it is the "smallest" next.
        reverseFrom(nums, start + 1);
    }

    // Reverses a part of the array.
    private void reverseFrom(int[] nums, int start) {
        int front = start;
        int back = nums.length - 1;

        while (front < back) {
            int temp = nums[front];
            nums[front] = nums[back];
            nums[back] = temp;

            front++;
            back--;
        }
    }

    // Swaps two elements in the array.
    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}

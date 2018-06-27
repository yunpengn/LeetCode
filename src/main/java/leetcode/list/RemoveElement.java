package leetcode.list;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 1) {
            return nums[0] == val ? 0 : 1;
        }

        // Defines two pointers for array indices.
        int head = 0;
        int tail = nums.length - 1;

        while (head < nums.length && head < tail) {
            if (nums[head] != val) {
                head++;
            } else if (nums[tail] == val) {
                tail--;
            } else {
                swap(nums, head, tail);
            }
        }

        return head;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

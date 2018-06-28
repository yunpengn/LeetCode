package leetcode.list;

public class SearchInsert {
    // Converts this problem into binary search (with minor changes).
    // Pre-condition: no duplicates in the array.
    public int searchInsert(int[] nums, int target) {
        // Two pointers of indices to store the range.
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return nums[start] < target ? start + 1 : start;
    }
}

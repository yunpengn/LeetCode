package leetcode.search;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{searchFirst(nums, target), searchLast(nums, target)};
    }

    private int searchFirst(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return nums[start] == target ? start : -1;
    }

    private int searchLast(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = (start + end + 1) / 2;

            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }

        return nums[start] == target ? start : -1;
    }
}

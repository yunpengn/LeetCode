package leetcode.search;

public class SearchRotated {
    // Defines "the amount of rotation".
    private static int rotation = 0;
    // The length of the current array.
    private static int length = 1;

    // Adopts a twice-binary-search approach. In other words, we use
    // the 1st binary search to confirm the rotation; then, we use the
    // 2nd binary search to find the actual target.
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        length = nums.length;

        // First search for "the amount of rotation" (i.e., the lowest point).
        while (start < end) {
            int mid = (start + end) / 2;

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        rotation = start;
        start = 0;
        end = nums.length - 1;

        // Then searches for the actual target.
        while (start < end) {
            int mid = (start + end) / 2;

            if (nums[rotate(mid)] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return nums[rotate(start)] == target ? rotate(start) : -1;
    }

    // Applies the rotation effect on the index.
    private int rotate(int index) {
        return (index + rotation) % length;
    }
}

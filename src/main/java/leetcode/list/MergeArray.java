package leetcode.list;

/**
 * Merging array is different from merge linked list because we want to keep constant space.
 *
 * @author yunpeng
 */
public class MergeArray {
    // The merging result will be stored in nums1 array.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0;
        int index2 = 0;

        while (index1 < m && index2 < n) {
            if (nums1[index1] <= nums2[index2]) {
                index1++;
            } else {
                int temp = nums1[index1];
                nums1[index1] = nums2[index2];
                nums2[index2] = temp;
                index1++;
            }
        }

        while (index2 < n) {
            nums1[index1] = nums2[index2];
            index1++;
            index2++;
        }
    }
}

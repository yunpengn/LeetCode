package leetcode;

public class TwoArrayMedian {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return (nums2[nums2.length / 2] + nums2[(nums2.length - 1) / 2]) / 2;
        } else if (nums2.length == 0) {
            return (nums1[nums1.length / 2] + nums1[(nums1.length - 1) / 2]) / 2;
        }
        return findMedian(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1);
    }

    // A helper function for recursive purpose.
    private double findMedian(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2) {
        if (start1 == end1 && start2 == end2) {
            return (nums1[start1] + nums2[start2]) / 2;
        }

        // Two median indices.
        int medianIndex1 = (start1 + end1) / 2;
        int medianIndex2 = (start2 + end2) / 2;

        if (nums1[medianIndex1] < nums2[medianIndex2]) {
            return findMedian(nums1, nums2, medianIndex1 + 1, end1, start2, medianIndex2);
        } else if (nums1[medianIndex1] > nums2[medianIndex2]) {
            return findMedian(nums1, nums2, start1, medianIndex1, medianIndex2 + 1, end2);
        } else {
            // Special considerations for the case when both lengths are even.
            if (nums1.length % 2 == 0 && nums2.length % 2 == 0) {
                int other = Math.min(nums1[medianIndex1 + 1], nums2[medianIndex2 + 1]);
                return (nums1[medianIndex1] + other) / 2;
            } else {
                return nums1[medianIndex1];
            }
        }
    }
}

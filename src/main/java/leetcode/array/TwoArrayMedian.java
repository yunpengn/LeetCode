package leetcode.array;

public class TwoArrayMedian {
    public double findMedianSortedArrays(int[] A, int[] B) {
        // To ensure A is always shorted than B.
        if (A.length > B.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        int iMin = 0;
        int iMax = A.length;
        int halfLen = (A.length + B.length + 1) / 2;

        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;

            if (i < iMax && B[j-1] > A[i]){
                // i is too small
                iMin = iMin + 1;
            } else if (i > iMin && A[i-1] > B[j]) {
                // i is too big
                iMax = iMax - 1;
            } else {
                // i is perfect
                int maxLeft = 0;

                if (i == 0) {
                    maxLeft = B[j-1];
                } else if (j == 0) {
                    maxLeft = A[i-1];
                } else {
                    maxLeft = Math.max(A[i-1], B[j-1]);
                }

                if ((A.length + B.length) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == A.length) {
                    minRight = B[j];
                } else if (j == B.length) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}

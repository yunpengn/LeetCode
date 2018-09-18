package practice;

/**
 * A naive implementation of quicksort, whose average time complexity is O(n * logn),
 * while worst case could grow up to O(n^2).
 *
 * Notice: The sorting result is in ascending order.
 *
 * @author Niu Yunpeng
 */
public class Quicksort {
    /**
     * Sorts an array of integers using quicksort.
     *
     * @param arr the array to be sorted.
     */
    void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * Sorts an array of integers within a certain range using quicksort.
     * @param arr the array to be sorted.
     * @param start the starting index of the intended range.
     * @param end the ending index of the intended range.
     */
    private void sort(int[] arr, int start, int end) {
        if (start >= end || start >= arr.length || end < 0) {
            return;
        }
        int separated = partition(arr, start, end);

        sort(arr, start, separated - 1);
        sort(arr, separated + 1, end);
    }

    /**
     * Selects the kth smallest element from the given array.
     *
     * @param arr is an array of integers.
     * @param k is the index of the result.
     *
     * @return the value of the kth smallest element.
     */
    int select(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int position = -1;

        // Finds the position of a selected pivot.
        while (start < end) {
            position = partition(arr, start, end);

            // Updates the range.
            if (position == k) {
                return arr[position];
            } else if (position > k) {
                end = position - 1;
            } else {
                start = position + 1;
            }
        }

        return Integer.MAX_VALUE;
    }

    /**
     * Partitions an array by a given pivot value. Here, we always use the first
     * element within the intended range as the pivot.
     *
     * @param arr the array to be partitioned.
     * @param start the starting index of the intended range.
     * @param end the ending index of the intended range.
     * @return the index at which the pivot is in the end placed.
     */
    private int partition(int[] arr, int start, int end) {
        int separated = -1;
        int origin = start;
        int pivot = arr[start];

        start = start + 1;
        while (start < end) {
            while (arr[start] < pivot && start < end) {
                start++;
            }

            while (arr[end] > pivot && start < end) {
                end--;
            }

            if (start < end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }

        if (arr[start] >= pivot) {
            separated = start - 1;
        } else {
            separated = start;
        }
        swap(arr, origin, separated);

        return separated;
    }

    /**
     * Swaps the two elements in an array. This operation is possible due to the
     * fact that array in Java is passed by reference.
     *
     * @param arr the array to be swapped.
     * @param index1 the index of the first element.
     * @param index2 the index of the second element.
     */
    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}

package practice;

/**
 * A class that implements the classical binary search algorithm that can search for
 * the first & last occurrence of an element in an array of integers.
 *
 * @author Niu Yunpeng
 */
public class BinarySearch {
    /**
     * Searches for the first occurrence of a certain target in a given array. This
     * version provides a recursive approach.
     *
     * @param arr the sorted array of integers to be searched on.
     * @param target the element to search for.
     * @return the index of the first occurrence; -1 otherwise.
     */
    int searchFirstRecursive(int[] arr, int target) {
        return searchFirstRecursive(arr, 0, arr.length - 1, target);
    }

    private int searchFirstRecursive(int[] arr, int start, int end, int target) {
        if (start >= end) {
            return arr[start] == target ? start : -1;
        } else {
            int mid = (start + end) / 2;

            if (target > arr[mid]) {
                return searchFirstRecursive(arr, mid + 1, end, target);
            } else {
                return searchFirstRecursive(arr, start, mid, target);
            }
        }
    }

    /**
     * Searches for the first occurrence of a certain target in a given array. This
     * version provides an iterative approach.
     *
     * @param arr the sorted array of integers to be searched on.
     * @param target the element to search for.
     * @return the index of the first occurrence; -1 otherwise.
     */
    int searchFirstIterative(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;

            if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return arr[start] == target ? start : -1;
    }

    /**
     * Searches for the last occurrence of a certain target in a given array. This
     * version provides a recursive approach.
     *
     * @param arr the sorted array of integers to be searched on.
     * @param target the element to search for.
     * @return the index of the last occurrence; -1 otherwise.
     */
    int searchLastRecursive(int[] arr, int target) {
        return searchLastRecursive(arr, 0, arr.length - 1, target);
    }

    private int searchLastRecursive(int[] arr, int start, int end, int target) {
        if (start >= end) {
            return arr[start] == target ? start : -1;
        } else {
            int mid = (start + end + 1) / 2;

            if (target >= arr[mid]) {
                return searchLastRecursive(arr, mid, end, target);
            } else {
                return searchLastRecursive(arr, start, mid - 1, target);
            }
        }
    }

    /**
     * Searches for the last occurrence of a certain target in a given array. This
     * version provides an iterative approach.
     *
     * @param arr the sorted array of integers to be searched on.
     * @param target the element to search for.
     * @return the index of the last occurrence; -1 otherwise.
     */
    int searchLastIterative(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = (start + end + 1) / 2;

            if (target >= arr[mid]) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }

        return arr[start] == target ? start : -1;
    }
}

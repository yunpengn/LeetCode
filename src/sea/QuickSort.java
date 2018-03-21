package sea;

public class QuickSort<T extends Comparable<T>> {
    // Notice: Although average time complexity is O(nlogn), this
    // may result in O(n^2).
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = arr[start];
            int separated = partition(arr, start, end, pivot);

            sort(arr, start, separated);
            sort(arr, separated, end);
        }
    }

    // start and end are indices, pivot is the value, not index.
    private int partition(int[] arr, int start, int end, int pivot) {
        int separated = -1;
        int origin = start;

        start = start + 1;
        while (start < end) {
            while (arr[start] < pivot && start < end) {
                start++;
            }

            while (arr[end] > pivot && start < end) {
                end++;
            }

            if (start < end) {
                swap(arr, start, end);
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

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = arr[index1];
    }
}

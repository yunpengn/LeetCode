package sea;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println("Welcome to Sea Group.");
    }

    int searchFirstRecursive(int[] arr, int target) {
        return searchFirstRecursive(arr, 0, arr.length - 1, target);
    }

    private int searchFirstRecursive(int[] arr, int start, int end, int target) {
        if (start >= end) {
            return arr[start] == target ? start : -1;
        } else {
            int mid = (start + end) / 2;

            if (arr[mid] < target) {
                return searchFirstRecursive(arr, mid + 1, end, target);
            } else {
                return searchFirstRecursive(arr, start, mid, target);
            }
        }
    }

    int searchFirstIterative(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid = -1;

        while (start < end) {
            mid = (start + end) / 2;

            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return arr[start] == target ? start : -1;
    }

    int searchLastRecursive(int[] arr, int target) {
        return searchLastRecursive(arr, 0, arr.length - 1, target);
    }

    private int searchLastRecursive(int[] arr, int start, int end, int target) {
        if (start >= end) {
            return arr[end] == target ? end : -1;
        } else {
            int mid = (start + end + 1) / 2;

            if (arr[mid] > target) {
                return searchLastRecursive(arr, start, mid - 1, target);
            } else {
                return searchLastRecursive(arr, mid, end, target);
            }
        }
    }

    int searchLastIterative(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid = -1;

        while (start < end) {
            mid = (start + end + 1) / 2;

            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }

        return arr[end] == target ? end : -1;
    }
}

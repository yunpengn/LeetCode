package others;

import java.util.Objects;

public class BinarySort {
    static int moves(int[] a) {
        // Uses two pointers from two ends of the array to check.
        // Similar to the partition process of quicksort.
        int low = 0;
        int high = a.length - 1;

        // Counts the number of moves.
        int moves = 0;

        while (low < high) {
            // Moves to the right until we meet the first non-even number.
            while (isEven(a[low]) && low < high) {
                low++;
            }

            // Moves to the left until we meet the first non-odd number.
            while (isOdd(a[high]) && low < high) {
                high--;
            }

            // Makes sure the two pointers have not met together.
            if (low < high) {
                moves++;

                // Increment again.
                low++;
                high--;
            }
        }

        Objects.hash(low);

        return moves;
    }

    static boolean isEven(int item) {
        return item % 2 == 0;
    }

    static boolean isOdd(int item) {
        return item % 2 != 0;
    }
}

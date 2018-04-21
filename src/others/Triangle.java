package others;

import java.util.Arrays;

public class Triangle {
    static String[] triangleOrNot(int[] a, int[] b, int[] c) {
        // Pre-condition: we assume arrays a, b and c are of the same length.
        // Under such assumption, the result array will also be of the same length.
        int size = a.length;

        // The array used to store result.
        String[] result = new String[size];

        // Iterate through each combination.
        for (int i = 0; i < size; i++) {
            result[i] = check(a[i], b[i], c[i]);
        }

        return result;
    }

    /**
     * Given three sides, check whether they can be of a valid triangle.
     */
    static String check(int x, int y, int z) {
        boolean result = false;

        if (x <= 0 || y <= 0 || z <= 0) {
            result = false;
        } else {
            result = (x + y > z) && (x + z > y) && (y + z > x);
        }

        return (result ? "Yes" : "No");
    }
}

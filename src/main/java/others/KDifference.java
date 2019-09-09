package others;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KDifference {
    public int kDifference(List<Integer> arr, int k) {
        // Stores all the values in the array as a hash set.
        Set<Integer> values = new HashSet<>(arr);

        int count = 0;
        for (int num: values) {
            if (values.contains(num + k)) {
                count++;
            }
        }

        return count;
    }
}

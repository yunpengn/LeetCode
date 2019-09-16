package others;

import java.util.HashMap;
import java.util.Map;

public class Binarian {
    int count(int[] A) {
        Map<Integer, Integer> values = new HashMap<>();
        int max = 0;
        for (int item: A) {
            if (item > max) {
                max = item;
            }

            int oldCount = values.getOrDefault(item, 0);
            values.put(item, oldCount + 1);
        }

        int current = 0;
        for (int i = 0; i <= max || current > 0; i++) {
            if (!values.containsKey(i)) {
                continue;
            }

            current = values.get(i);
            int oldNext = values.getOrDefault(i + 1, 0);
            values.put(i, current % 2);
            values.put(i + 1, oldNext + current / 2);
        }

        int sum = 0;
        for (int count: values.values()) {
            sum += count;
        }
        return sum;
    }
}

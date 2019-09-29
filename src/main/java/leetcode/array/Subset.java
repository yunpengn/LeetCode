package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num: nums) {
            int currentSize = result.size();
            for (int i = 0; i < currentSize; i++) {
                List<Integer> newList = new ArrayList<>(result.get(i));
                newList.add(num);
                result.add(newList);
            }
        }

        return result;
    }
}

package leetcode.list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<>());

        for (int item: nums) {
            int length = result.size();
            for (int i = 0; i < length; i++) {
                List<Integer> permutation = result.remove(0);

                int size = permutation.size();
                for (int j = 0; j <= size; j++) {
                    List<Integer> newPermutation = new LinkedList<>(permutation);
                    newPermutation.add(j, item);
                    result.add(newPermutation);
                }
            }
        }

        return result;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<>());
        Arrays.sort(nums);

        for (int m = 0; m < nums.length; m++) {
            int length = result.size();
            for (int i = 0; i < length; i++) {
                List<Integer> permutation = result.remove(0);

                int size = permutation.size();
                for (int j = 0; j <= size; j++) {
                    List<Integer> newPermutation = new LinkedList<>(permutation);
                    newPermutation.add(j, nums[m]);
                    result.add(newPermutation);
                }
            }
        }

        return result;
    }
}

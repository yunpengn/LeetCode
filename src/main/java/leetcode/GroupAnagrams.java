package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> grouping = new HashMap<>();
        for (String word: strs) {
            String sorted = sort(word);
            if (grouping.containsKey(sorted)) {
                grouping.get(sorted).add(word);
            } else {
                List<String> items = new LinkedList<>();
                items.add(word);
                grouping.put(sorted, items);
            }
        }

        return new LinkedList<>(grouping.values());
    }

    private String sort(String input) {
        char[] arr = input.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNA {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        // Mapping from string of length 10 to whether been added to result list.
        Map<String, Boolean> foundSoFar = new HashMap<>();

        for (int i = 0; i < s.length() - 9; i++) {
            String current = s.substring(i, i + 10);
            if (!foundSoFar.containsKey(current)) {
                foundSoFar.put(current, false);
            } else if (!foundSoFar.get(current)) {
                result.add(current);
                foundSoFar.put(current, true);
            }
        }

        return result;
    }
}

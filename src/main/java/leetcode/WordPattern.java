package leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        // Split the string by a single whitespace.
        String[] words = str.split("\\s");

        if (words.length != pattern.length()) {
            return false;
        } else {
            Map<Character, String> mapping1 = new HashMap<>();
            Map<String, Character> mapping2 = new HashMap<>();

            for (int i = 0; i < pattern.length(); i++) {
                char current = pattern.charAt(i);
                String currentWord = words[i];

                if (!mapping1.containsKey(current) && !mapping2.containsKey(currentWord)) {
                    mapping1.put(current, currentWord);
                    mapping2.put(currentWord, current);
                } else if (!currentWord.equals(mapping1.get(current)) || current != mapping2.get(currentWord)) {
                    return false;
                }
            }

            return true;
        }
    }
}

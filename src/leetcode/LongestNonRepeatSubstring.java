package leetcode;

import java.util.HashMap;

public class LongestNonRepeatSubstring {
    // Pre-condition: assume all letters in the input string is lowercase.
    public int lengthOfLongestSubstring(String s) {
        // A mapping from 26 letters to their index within the string. They may be removed if they
        // are not within the current substring anymore.
        HashMap<Character, Integer> mapping = new HashMap<>();

        // The length of the longest substring.
        int longest = 0;

        // The starting point of the current substring.
        int currentStart = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // Checks whether the current character exists in the mapping previously.
            if (mapping.containsKey(currentChar)) {
                // If so, the starting point of the current substring needs to change.
                int newStart = mapping.get(currentChar) + 1;

                // Removes these characters in the mapping.
                for (int j = currentStart; j < newStart; j++) {
                    mapping.remove(s.charAt(j));
                }

                // Updates the starting point.
                currentStart = newStart;
            }

            // Inserts the current character into the mapping.
            mapping.put(currentChar, i);

            // Checks whether the current substring becomes the longest substring.
            if (i - currentStart + 1 > longest) {
                longest = i - currentStart + 1;
            }
        }

        return longest;
    }
}

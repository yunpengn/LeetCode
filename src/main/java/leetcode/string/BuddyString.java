package leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class BuddyString {
    public boolean buddyStrings(String A, String B) {
        // Returns false directly if two strings are not the same length.
        if (A.length() != B.length()) {
            return false;
        }

        // To store the index of the first different pair of characters.
        int firstDiff = -1;
        // To store the index of the second different pair of characters.
        int secondDiff = -1;

        // Uses this to check whether there exists duplicate characters in string A.
        Set<Character> chars = new HashSet<>();
        boolean hasDuplicate = false;

        char currentA;
        char currentB;
        // Iterates through each character for string A and B.
        for (int i = 0; i < A.length(); i++) {
            currentA = A.charAt(i);
            currentB = B.charAt(i);

            if (currentA != currentB) {
                if (firstDiff == -1) {
                    // Records the position of the first different pair.
                    firstDiff = i;
                } else if (secondDiff != -1) {
                    // Returns false if there are more than two different pairs.
                    return false;
                } else if (A.charAt(firstDiff) == currentB && currentA == B.charAt(firstDiff)) {
                    // Records the position of the second different pair.
                    secondDiff = i;
                } else {
                    // Returns false if two strings are not the same after swap.
                    return false;
                }
            }

            if (!hasDuplicate) {
                if (chars.contains(currentA)) {
                    hasDuplicate = true;
                } else {
                    chars.add(currentA);
                }
            }
        }

        // Returns true only if they could be possibly the same after exactly one swap.
        if (firstDiff != -1 && secondDiff != -1) {
            return true;
        } else if (firstDiff == -1 && secondDiff == -1) {
            // Special case when the two strings are the same (they may have duplicate characters).
            return hasDuplicate;
        } else {
            return false;
        }
    }
}

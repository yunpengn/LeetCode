package others;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        // Prepares the input.
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] tokens = sc.nextLine().split("\\s+");
        Set<String> dict = new HashSet<>(Arrays.asList(tokens));

        if (check(line, dict)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    private static boolean check(String line, Set<String> tokens) {
        if (line.isEmpty()) {
            return true;
        }

        // canSplit[i] means the substring of [0, i - 1] can be split into subsets of the tokens.
        boolean[] canSplit = new boolean[line.length() + 1];

        for (int i = 0; i <= line.length(); i++) {
            // If the whole substring is allowed.
            if (!canSplit[i] && tokens.contains(line.substring(0, i))) {
                canSplit[i] = true;
            }

            // Continues if the current point is of no use.
            if (!canSplit[i]) {
                continue;
            }

            if (i == line.length()) {
                return true;
            }

            for (int j = i + 1; j <= line.length(); j++) {
                if (!canSplit[j] && tokens.contains(line.substring(i, j))) {
                    canSplit[j] = true;
                }

                if (j == line.length() && canSplit[j]) {
                    return true;
                }
            }
        }

        return canSplit[line.length()];
    }
}

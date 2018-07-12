package leetcode;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        } else if (n == 1) {
            return "1";
        } else if (n == 2) {
            return "11";
        }

        StringBuilder builder = new StringBuilder();
        char[] previous = countAndSay(n - 1).toCharArray();

        int currentCount = 1;
        for (int i = 1; i < previous.length; i++) {
            if (previous[i] == previous[i - 1]) {
                currentCount++;
            } else {
                builder.append(Integer.toString(currentCount));
                builder.append(previous[i - 1]);
                currentCount = 1;
            }
        }

        if (currentCount != 0) {
            builder.append(Integer.toString(currentCount));
            builder.append(previous[previous.length - 1]);
        }

        return builder.toString();
    }
}

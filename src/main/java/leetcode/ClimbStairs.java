package leetcode;

public class ClimbStairs {
    public int climbStairs(int n) {
        if (n < 0) {
            return 0;
        } else if (n <= 1) {
            return 1;
        }

        int lastTwo = 1;
        int lastOne = 1;
        int current = 2;

        for (int i = 2; i <= n; i++) {
            current = lastTwo + lastOne;
            lastTwo = lastOne;
            lastOne = current;
        }

        return current;
    }
}

package leetcode.math;

public class ReachNumber {
    public int reachNumber(int target) {
        // The axis is symmetric.
        long tar = Math.abs(target);

        // Keep summing up: 1 + 2 + 3 + ... + n >= target
        long n = (int) Math.ceil((Math.sqrt(tar * 8 + 1) - 1) / 2);
        long sum = (n + 1) * n / 2;

        if (sum == target) {
            // Returns n if the sum is exactly the target.
            return (int) n;
        } else {
            long difference = sum - target;

            // We only need to flip one of [1, n] if the difference is even.
            if (difference % 2 == 0) {
                return (int) n;
            } else if ((difference + n + 1) % 2 == 0) {
                // Tries to add n + 1 first, if the new difference is even, then flip one of [1, n + 1].
                return (int) (n + 1);
            } else {
                // Adds n + 1 and n + 2 first, then it is guaranteed that the difference is even.
                return (int) (n + 2);
            }
        }
    }
}

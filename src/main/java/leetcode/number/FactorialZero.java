package leetcode.number;

public class FactorialZero {
    public int trailingZeroes(int n) {
        // In factorial, factors of 2 is always more than factors of 5. So
        // the constraint is on factors of 5.
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}

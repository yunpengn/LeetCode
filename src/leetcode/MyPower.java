package leetcode;

public class MyPower {
    public double myPow(double x, int n) {
        double result = 1;

        if (n > 0) {
            while (n > 0) {
                if (n % 2 == 0) {
                    x = x * x;
                    n /= 2;
                } else {
                    result *= x;
                    n -= 1;
                }
            }
        } else if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                if (x == 1 || x == -1) {
                    return 1;
                } else {
                    return 0;
                }
            }
            n = -n;
            while (n > 0) {
                if (n % 2 == 0) {
                    x = x * x;
                    n /= 2;
                } else {
                    result /= x;
                    n -= 1;
                }
            }
        } else {
            return 1;
        }

        return result;
    }

    public double myPowSlow(double x, int n) {
        double result = 1;

        if (n > 0) {
            for (int i = 0; i < n; i++) {
                result *= x;
            }
        } else if (n < 0) {
            for (int i = 0; i < -n; i++) {
                result /= x;
            }
        }

        return result;
    }
}

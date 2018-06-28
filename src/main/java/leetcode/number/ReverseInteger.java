package leetcode.number;

public class ReverseInteger {
    public int reverse(int x) {
        int input = Math.abs(x);
        int output = 0;

        while (input > 0) {
            int digit = input % 10;
            input /= 10;
            int newOutput = output * 10 + digit;

            if ((newOutput - digit) / 10 != output) {
                return 0;
            }
            output = newOutput;
        }

        return x < 0 ? -output : output;
    }
}

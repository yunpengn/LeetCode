package leetcode;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] soFar = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            int min = -1;
            for (int coin: coins) {
                if (i >= coin && soFar[i - coin] != -1) {
                    int current = soFar[i - coin] + 1;
                    if (min < 0) {
                        min = current;
                    } else {
                        min = Math.min(min, current);
                    }
                }
            }

            soFar[i] = min;
        }

        return soFar[amount];
    }
}

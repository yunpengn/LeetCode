package leetcode.list;

public class StockPrice {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int minPriceSoFar = prices[0];
        int maxProfitSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            int current = prices[i];
            if (current - minPriceSoFar > maxProfitSoFar) {
                maxProfitSoFar = current - minPriceSoFar;
            }

            if (current < minPriceSoFar) {
                minPriceSoFar = current;
            }
        }

        return maxProfitSoFar;
    }
}

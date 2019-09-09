package others;

import java.util.List;

public class ShoppingCart {
    public int shopping(int n, List<Integer> quantities, List<Integer> prices) {
        int[] table = new int[n + 1];
        table[0] = 0;

        int numOfShops = quantities.size();
        for (int i = 1; i <= n; i++) {
            int bestSoFar = table[i - 1];
            for (int j = 0; j < numOfShops; j++) {
                int bundleQuantity = quantities.get(j);
                int bundleCost = prices.get(j);

                if (i - bundleCost >= 0) {
                    int current = table[i - bundleCost] + bundleQuantity;
                    if (current > bestSoFar) {
                        bestSoFar = current;
                    }
                }
            }
            table[i] = bestSoFar;
        }

        return table[n];
    }
}

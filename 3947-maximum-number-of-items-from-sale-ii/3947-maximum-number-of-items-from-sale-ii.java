
import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        // Step 1: Find minimum price and maximum factor
        int minPrice = Integer.MAX_VALUE;
        int maxFactor = 0;

        for (int[] item : items) {
            minPrice = Math.min(minPrice, item[1]);
            maxFactor = Math.max(maxFactor, item[0]);
        }

        // Step 2: Count frequency of every factor
        int[] freq = new int[maxFactor + 1];

        for (int[] item : items) {
            freq[item[0]]++;
        }

        // Step 3: Sieve - count all multiples
        for (int i = 1; i <= maxFactor; i++) {

            for (int j = 2 * i; j <= maxFactor; j += i) {
                freq[i] += freq[j];
            }
        }

        // Step 4: Group useful free-copy opportunities by price
        TreeMap<Long, Long> costCount = new TreeMap<>();

        for (int[] item : items) {

            int factor = item[0];
            int price = item[1];

            // Exclude the item itself
            int gain = freq[factor] - 1;

            // A copy is useful if it gives 2 items
            // and costs at most twice the cheapest price
            if (gain > 0 && price <= 2L * minPrice) {

                costCount.put(
                    (long) price,
                    costCount.getOrDefault((long) price, 0L) + gain
                );
            }
        }

        // Step 5: Greedily purchase boosted copies
        long total = 0;

        for (Map.Entry<Long, Long> entry : costCount.entrySet()) {

            long price = entry.getKey();
            long count = entry.getValue();

            long buy = Math.min(count, budget / price);

            total += 2 * buy;
            budget -= (int) (buy * price);
        }

        // Step 6: Spend remaining budget on cheapest items
        total += budget / minPrice;

        return (int) total;
    }
}

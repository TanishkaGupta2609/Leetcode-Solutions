class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long minCoin = coins[0];
        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }

        long left = 1;
        long right = minCoin * k;
        long result = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (countDistinct(coins, mid) >= k) {
                result = mid;
                right = mid - 1; // Try finding a smaller valid amount
            } else {
                left = mid + 1;  // Need a larger amount
            }
        }

        return result;
    }

    private long countDistinct(int[] coins, long x) {
        int n = coins.length;
        long count = 0;

        // Iterate through all 2^n - 1 non-empty subsets
        for (int mask = 1; mask < (1 << n); mask++) {
            long currentLcm = 1;
            int setBits = 0;
            boolean overflow = false;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    setBits++;
                    currentLcm = lcm(currentLcm, coins[i]);
                    if (currentLcm > x) { 
                        overflow = true;
                        break; 
                    }
                }
            }

            if (overflow) continue;

            if (setBits % 2 == 1) {
                count += x / currentLcm;
            } else {
                count -= x / currentLcm;
            }
        }

        return count;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}
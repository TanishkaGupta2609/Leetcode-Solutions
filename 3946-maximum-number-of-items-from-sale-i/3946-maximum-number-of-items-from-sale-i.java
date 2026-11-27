class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] bonus = new int[n];

        for (int i = 0; i < n; i++) {
            int f = items[i][0];
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % f == 0) {
                    cnt++;
                }
            }
            bonus[i] = cnt;
        }

        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int free = bonus[i];
            if (price > budget) continue;

            // 1st copy: gives 1 bought + `free` free copies (0-1 style per item i)
            for (int b = budget; b >= price; b--) {
                dp[b] = Math.max(dp[b], dp[b - price] + 1 + free);
            }

            // Additional copies: gives 1 copy each, no extra freebies (unbounded)
            for (int b = price; b <= budget; b++) {
                dp[b] = Math.max(dp[b], dp[b - price] + 1);
            }
        }

        int ans = 0;
        for (int val : dp) {
            ans = Math.max(ans, val);
        }
        return ans;
    }
}
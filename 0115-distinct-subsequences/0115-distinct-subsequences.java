class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // 1D DP array initialized for target string length
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: 1 way to form empty string t

        for (int i = 1; i <= m; i++) {
            char sChar = s.charAt(i - 1);
            for (int j = n; j >= 1; j--) {
                if (sChar == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n];
    }
}
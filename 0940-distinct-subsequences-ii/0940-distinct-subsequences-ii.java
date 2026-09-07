class Solution {
    public int distinctSubseqII(String s) {
        long[] last = new long[26];
        long MOD = 1_000_000_007;

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            long currentSum = 0;
            for (long count : last) {
                currentSum = (currentSum + count) % MOD;
            }
            last[idx] = (currentSum + 1) % MOD;
        }

        long total = 0;
        for (long count : last) {
            total = (total + count) % MOD;
        }

        return (int) total;
    }
}
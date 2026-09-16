class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {
        long totalPoints = n + k - 1;
        long totalSegments = 2 * k;

        if (totalPoints < totalSegments) {
            return 0;
        }

        // Calculate C(n + k - 1, 2 * k) % MOD
        long numerator = 1;
        long denominator = 1;

        for (int i = 1; i <= totalSegments; i++) {
            numerator = (numerator * (totalPoints - i + 1)) % MOD;
            denominator = (denominator * i) % MOD;
        }

        return (int) (numerator * modInverse(denominator, MOD) % MOD);
    }

    private long modInverse(long a, int m) {
        return power(a, m - 2, m);
    }

    private long power(long base, long exp, int mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}
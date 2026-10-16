class Solution {
    static final int MOD = 1_000_000_007;
    
    long[] sumSq;
    long[] sumV;
    long[] lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sumSq = new long[4 * n];
        sumV = new long[4 * n];
        lazy = new long[4 * n];
        
        java.util.HashMap<Integer, Integer> lastSeen = new java.util.HashMap<>();
        long totalSum = 0;
        
        for (int j = 0; j < n; j++) {
            int val = nums[j];
            int prev = lastSeen.getOrDefault(val, -1);
            lastSeen.put(val, j);
            
            // Update range [prev + 1, j] adding 1 to distinct counts
            update(1, 0, n - 1, prev + 1, j, 1);
            
            totalSum = (totalSum + sumSq[1]) % MOD;
        }
        
        return (int) totalSum;
    }

    private void push(int node, int l, int r) {
        if (lazy[node] != 0) {
            int mid = (l + r) / 2;
            apply(2 * node, l, mid, lazy[node]);
            apply(2 * node + 1, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }
    }

    private void apply(int node, int l, int r, long add) {
        // sumSq_new = sum((v + add)^2) = sumSq + 2 * add * sumV + add^2 * (r - l + 1)
        long len = (r - l + 1);
        sumSq[node] = (sumSq[node] + 2 * add * sumV[node] + add * add * len) % MOD;
        sumV[node] = (sumV[node] + add * len) % MOD;
        lazy[node] = (lazy[node] + add) % MOD;
    }

    private void update(int node, int l, int r, int ql, int qr, long val) {
        if (ql > r || qr < l) return;
        if (ql <= l && r <= qr) {
            apply(node, l, r, val);
            return;
        }
        push(node, l, r);
        int mid = (l + r) / 2;
        update(2 * node, l, mid, ql, qr, val);
        update(2 * node + 1, mid + 1, r, ql, qr, val);
        sumSq[node] = (sumSq[2 * node] + sumSq[2 * node + 1]) % MOD;
        sumV[node] = (sumV[2 * node] + sumV[2 * node + 1]) % MOD;
    }
}
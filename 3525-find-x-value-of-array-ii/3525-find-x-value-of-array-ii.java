class Solution {
    static class Node {
        int prod;
        int[] cnt;

        Node(int k) {
            this.prod = 1;
            this.cnt = new int[k];
        }
    }

    private Node[] tree;
    private int K;
    private int N;

    private Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;

        Node res = new Node(K);
        res.prod = (left.prod * right.prod) % K;

        for (int r = 0; r < K; r++) {
            res.cnt[r] = left.cnt[r];
        }

        for (int r = 0; r < K; r++) {
            if (right.cnt[r] > 0) {
                int combinedRem = (left.prod * r) % K;
                res.cnt[combinedRem] += right.cnt[r];
            }
        }

        return res;
    }

    private void build(int[] nums, int node, int l, int r) {
        if (l == r) {
            tree[node] = new Node(K);
            int rem = nums[l] % K;
            tree[node].prod = rem;
            tree[node].cnt[rem] = 1;
            return;
        }
        int mid = l + (r - l) / 2;
        build(nums, 2 * node, l, mid);
        build(nums, 2 * node + 1, mid + 1, r);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            int rem = val % K;
            tree[node].prod = rem;
            java.util.Arrays.fill(tree[node].cnt, 0);
            tree[node].cnt[rem] = 1;
            return;
        }
        int mid = l + (r - l) / 2;
        if (idx <= mid) {
            update(2 * node, l, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, r, idx, val);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private Node query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return tree[node];
        }
        int mid = l + (r - l) / 2;
        if (qr <= mid) {
            return query(2 * node, l, mid, ql, qr);
        }
        if (ql > mid) {
            return query(2 * node + 1, mid + 1, r, ql, qr);
        }

        Node leftRes = query(2 * node, l, mid, ql, qr);
        Node rightRes = query(2 * node + 1, mid + 1, r, ql, qr);
        return merge(leftRes, rightRes);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.N = nums.length;
        this.K = k;
        this.tree = new Node[4 * N];

        build(nums, 1, 0, N - 1);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, N - 1, idx, val);
            Node res = query(1, 0, N - 1, start, N - 1);
            ans[i] = res.cnt[x];
        }

        return ans;
    }
}
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            // Assign index parity directly
            ans[i] = (seq.charAt(i) == '(') ? (i % 2) : (1 - (i % 2));
        }

        return ans;
    }
}
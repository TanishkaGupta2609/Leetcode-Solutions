import java.util.*;

class Solution {
    private static final int MOD = 1000000007;
    private long[][] combinations;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        
        // Precompute combinations using Pascal's Triangle
        combinations = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            combinations[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                combinations[i][j] = (combinations[i - 1][j - 1] + combinations[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        // Subtract 1 because the problem asks for ways to *reorder* nums 
        // (excluding the original arrangement itself).
        return (int)((dfs(list) - 1 + MOD) % MOD);
    }

    private long dfs(List<Integer> nums) {
        if (nums.size() <= 2) {
            return 1;
        }

        int root = nums.get(0);
        List<Integer> leftTree = new ArrayList<>();
        List<Integer> rightTree = new ArrayList<>();

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < root) {
                leftTree.add(nums.get(i));
            } else {
                rightTree.add(nums.get(i));
            }
        }

        long leftWays = dfs(leftTree);
        long rightWays = dfs(rightTree);

        int leftSize = leftTree.size();
        int rightSize = rightTree.size();

        long comb = combinations[leftSize + rightSize][leftSize];

        long ans = (comb * leftWays) % MOD;
        ans = (ans * rightWays) % MOD;
        return ans;
    }
}
class Solution {
    private Boolean[][][] memo;

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // A valid parentheses string must have an even total length
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        // The start must be '(' and the end must be ')'
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        // Maximum balance cannot exceed (m + n) / 2
        int maxBalance = (m + n) / 2;
        memo = new Boolean[m][n][maxBalance + 1];

        return dfs(grid, 0, 0, 0, m, n, maxBalance);
    }

    private boolean dfs(char[][] grid, int r, int c, int balance, int m, int n, int maxBalance) {
        // Update balance based on current cell
        if (grid[r][c] == '(') {
            balance++;
        } else {
            balance--;
        }

        // If balance drops below 0 or exceeds max possible remaining open brackets
        if (balance < 0 || balance > maxBalance) {
            return false;
        }

        // Reached destination: check if balance is 0
        if (r == m - 1 && c == n - 1) {
            return balance == 0;
        }

        // Return cached result if already computed
        if (memo[r][c][balance] != null) {
            return memo[r][c][balance];
        }

        boolean found = false;

        // Move Down
        if (r + 1 < m) {
            found = dfs(grid, r + 1, c, balance, m, n, maxBalance);
        }

        // Move Right
        if (!found && c + 1 < n) {
            found = dfs(grid, r, c + 1, balance, m, n, maxBalance);
        }

        return memo[r][c][balance] = found;
    }
}
class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;

        // Precompute valid next positions for each cell and direction:
        // dir = 0 (moving right), dir = 1 (moving down)
        int[][][] nextPos = new int[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // For moving right (dir = 0)
                int currR = i, currC = j + 1;
                int dir = 0; // 0: moving right, 1: moving down
                boolean valid = true;

                while (currR >= 0 && currR < m && currC >= 0 && currC < n) {
                    if (grid[currR][currC] == 1) {
                        // Mirror reflection
                        if (dir == 0) {
                            // Moving right into mirror -> turn down
                            currR += 1;
                            dir = 1;
                        } else {
                            // Moving down into mirror -> turn right
                            currC += 1;
                            dir = 0;
                        }
                    } else {
                        // Empty cell, land here
                        break;
                    }
                }

                if (currR >= 0 && currR < m && currC >= 0 && currC < n && grid[currR][currC] == 0) {
                    nextPos[i][j][0] = currR * n + currC;
                } else {
                    nextPos[i][j][0] = -1; // Invalid / out of bounds
                }

                // For moving down (dir = 1)
                currR = i + 1;
                currC = j;
                dir = 1;
                valid = true;

                while (currR >= 0 && currR < m && currC >= 0 && currC < n) {
                    if (grid[currR][currC] == 1) {
                        if (dir == 0) {
                            currR += 1;
                            dir = 1;
                        } else {
                            currC += 1;
                            dir = 0;
                        }
                    } else {
                        break;
                    }
                }

                if (currR >= 0 && currR < m && currC >= 0 && currC < n && grid[currR][currC] == 0) {
                    nextPos[i][j][1] = currR * n + currC;
                } else {
                    nextPos[i][j][1] = -1;
                }
            }
        }

        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) continue;

                // Try moving right (mapped to index 0)
                int targetRight = nextPos[i][j][0];
                if (targetRight != -1) {
                    int tr = targetRight / n;
                    int tc = targetRight % n;
                    dp[tr][tc] = (dp[tr][tc] + dp[i][j]) % MOD;
                }

                // Try moving down (mapped to index 1)
                int targetDown = nextPos[i][j][1];
                if (targetDown != -1) {
                    int tr = targetDown / n;
                    int tc = targetDown % n;
                    dp[tr][tc] = (dp[tr][tc] + dp[i][j]) % MOD;
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }
}
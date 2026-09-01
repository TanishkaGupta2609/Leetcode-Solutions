import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int sr = -1, sc = -1;
        
        List<int[]> litters = new ArrayList<>();
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);
                if (ch == 'S') {
                    sr = r;
                    sc = c;
                } else if (ch == 'L') {
                    litters.add(new int[]{r, c});
                }
            }
        }
        
        int k = litters.size();
        int targetMask = (1 << k) - 1;
        
        // Map litter coordinates to bit index
        int[][] litterIdx = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(litterIdx[i], -1);
        for (int i = 0; i < k; i++) {
            litterIdx[litters.get(i)[0]][litters.get(i)[1]] = i;
        }
        
        // maxEnergy[r][c][mask] stores max energy remaining at (r, c, mask)
        int[][][] maxEnergy = new int[m][n][1 << k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(maxEnergy[i][j], -1);
            }
        }
        
        // Queue stores {r, c, mask, current_energy, steps}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc, 0, energy, 0});
        maxEnergy[sr][sc][0] = energy;
        
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], mask = curr[2], e = curr[3], steps = curr[4];
            
            if (mask == targetMask) {
                return steps;
            }
            
            if (e == 0) continue; // Out of energy, cannot move further
            
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || classroom[nr].charAt(nc) == 'X') {
                    continue;
                }
                
                int nextEnergy = e - 1;
                char cell = classroom[nr].charAt(nc);
                int nextMask = mask;
                
                if (cell == 'R') {
                    nextEnergy = energy;
                } else if (cell == 'L') {
                    int idx = litterIdx[nr][nc];
                    if (idx != -1) {
                        nextMask |= (1 << idx);
                    }
                }
                
                if (nextEnergy > maxEnergy[nr][nc][nextMask]) {
                    maxEnergy[nr][nc][nextMask] = nextEnergy;
                    queue.offer(new int[]{nr, nc, nextMask, nextEnergy, steps + 1});
                }
            }
        }
        
        return -1;
    }
}
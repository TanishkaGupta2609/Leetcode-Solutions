class Solution {
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];
        
        // First row: all free cells '.'
        StringBuilder firstRow = new StringBuilder();
        for (int j = 0; j < n; j++) {
            firstRow.append('.');
        }
        grid[0] = firstRow.toString();
        
        // Subsequent rows: obstacles '#' everywhere except the last column
        for (int i = 1; i < m; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n - 1; j++) {
                row.append('#');
            }
            row.append('.'); // last column is free to continue the downward path
            grid[i] = row.toString();
        }
        
        return grid;
    }
}
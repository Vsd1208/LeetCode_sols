// class Solution {
//     private boolean valid=false;
//     private void search(char[][] grid, int px, int py, int x, int y, boolean[][] visited) {
//     if(valid) return;
//     if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return;
//     if(visited[x][y]) {
//         if(!(x == px && y == py)) valid = true;
//         return;
//     }
//     visited[x][y] = true;
//     if(x + 1 < grid.length && grid[x + 1][y] == grid[x][y])
//         search(grid, x, y, x + 1, y, visited);
//     if(x - 1 >= 0 && grid[x - 1][y] == grid[x][y])
//         search(grid, x, y, x - 1, y, visited);
//     if(y + 1 < grid[0].length && grid[x][y + 1] == grid[x][y])
//         search(grid, x, y, x, y + 1, visited);
//     if(y - 1 >= 0 && grid[x][y - 1] == grid[x][y])
//         search(grid, x, y, x, y - 1, visited);
//     }
//     public boolean containsCycle(char[][] grid) {
//         int m = grid.length, n = grid[0].length;
//         boolean[][] visited = new boolean[m][n];
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 if(!visited[i][j]) {
//                     search(grid, -1, -1, i, j, visited);
//                     if(valid) return true; // stop early
//                 }
//             }
//         }
//         return valid;
//     }
// }
class Solution {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!visited[i][j]) {
                    if (dfs(grid, i, j, -1, -1, grid[i][j], visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, int r, int c, int prevR, int prevC, char color, boolean[][] visited) {
        visited[r][c] = true;

        for (int[] dir : DIRS) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length) {
                if (grid[nr][nc] == color) {
                    if (visited[nr][nc]) {
                        if (nr != prevR || nc != prevC) {
                            return true;
                        }
                    } else {
                        if (dfs(grid, nr, nc, r, c, color, visited)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}

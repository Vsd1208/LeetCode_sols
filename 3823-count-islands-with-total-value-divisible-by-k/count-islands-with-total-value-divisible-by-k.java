class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    long val = dfs(grid, visited, m, n, i, j);
                    if (val % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private long dfs(int[][] grid, boolean[][] visited,int m, int n, int i, int j) {

        if (i < 0 || j < 0 || i >= m || j >= n) return 0;
        if (grid[i][j] == 0 || visited[i][j]) return 0;
        visited[i][j] = true;
        long sum = grid[i][j];
        sum += dfs(grid, visited, m, n, i - 1, j);
        sum += dfs(grid, visited, m, n, i + 1, j);
        sum += dfs(grid, visited, m, n, i, j - 1);
        sum += dfs(grid, visited, m, n, i, j + 1);
        return sum;
    }
}
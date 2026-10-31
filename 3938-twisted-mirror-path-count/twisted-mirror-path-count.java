import java.util.Arrays;

class Solution {
    private static final int MOD = 1_000_000_007;
    private Long[][][] memo;
    private boolean[][][] visiting; // Track path to handle infinite loops

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Base edge case: single cell grid
        if (m == 1 && n == 1) return 1;

        // memo[i][j][dir]
        // dir = 0: entering (i, j) moving right
        // dir = 1: entering (i, j) moving down
        memo = new Long[m][n][2];
        visiting = new boolean[m][n][2];

        long totalPaths = 0;

        // From (0, 0), try initial move right (dir = 0)
        totalPaths = (totalPaths + dfs(grid, 0, 1, 0, m, n)) % MOD;

        // From (0, 0), try initial move down (dir = 1)
        totalPaths = (totalPaths + dfs(grid, 1, 0, 1, m, n)) % MOD;

        return (int) totalPaths;
    }

    private long dfs(int[][] grid, int r, int c, int dir, int m, int n) {
        // Out of bounds check
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return 0;
        }

        // Reached target destination
        if (r == m - 1 && c == n - 1) {
            return 1;
        }

        // Memoization check
        if (memo[r][c][dir] != null) {
            return memo[r][c][dir];
        }

        // Cycle detection: loop formed by mirrors
        if (visiting[r][c][dir]) {
            return 0;
        }

        visiting[r][c][dir] = true;
        long paths = 0;

        if (grid[r][c] == 1) { 
            // Mirror cell: reflects direction
            if (dir == 0) {
                // Was moving right -> turns down to (r + 1, c)
                paths = dfs(grid, r + 1, c, 1, m, n);
            } else {
                // Was moving down -> turns right to (r, c + 1)
                paths = dfs(grid, r, c + 1, 0, m, n);
            }
        } else { 
            // Empty cell: can continue either right or down
            // 1. Continue moving right
            paths = (paths + dfs(grid, r, c + 1, 0, m, n)) % MOD;
            // 2. Continue moving down
            paths = (paths + dfs(grid, r + 1, c, 1, m, n)) % MOD;
        }

        visiting[r][c][dir] = false;
        memo[r][c][dir] = paths;
        return paths;
    }
}
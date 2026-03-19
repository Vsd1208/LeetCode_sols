class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] val = new int[m][n];
        int[][] xCount = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'X') {
                    val[i][j] = 1;
                    xCount[i][j] = 1;
                } else if (grid[i][j] == 'Y') {
                    val[i][j] = -1;
                }
            }
        }
        int[][] pre = new int[m][n];
        int[][] preX = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pre[i][j] = val[i][j];
                preX[i][j] = xCount[i][j];
                if (i > 0) {
                    pre[i][j] += pre[i - 1][j];
                    preX[i][j] += preX[i - 1][j];
                }
                if (j > 0) {
                    pre[i][j] += pre[i][j - 1];
                    preX[i][j] += preX[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    pre[i][j] -= pre[i - 1][j - 1];
                    preX[i][j] -= preX[i - 1][j - 1];
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pre[i][j] == 0 && preX[i][j] > 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
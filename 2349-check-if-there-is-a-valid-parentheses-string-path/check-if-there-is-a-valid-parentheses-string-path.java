class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] == ')' || grid[m-1][n-1] == '(') {
            return false;
        }
        if((m + n - 1) % 2 != 0) {
            return false;
        }
        int[][][] dp = new int[m][n][m + n];
        dp[0][0][1] = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 && j == 0) {
                    continue;
                }
                for(int balance=0;balance<m+n;balance++){
                    int prevBalance;
                    if(grid[i][j] == '(') {
                        prevBalance = balance - 1;
                    }
                    else {
                        prevBalance = balance + 1;
                    }
                    if(prevBalance < 0 || prevBalance >= m+n) {
                        continue;
                    }
                    if(i > 0 && dp[i-1][j][prevBalance] == 1) {
                        dp[i][j][balance] = 1;
                    }
                    if(j > 0 && dp[i][j-1][prevBalance] == 1) {
                        dp[i][j][balance] = 1;
                    }
                }
            }
        }
        return dp[m-1][n-1][0] == 1;
    }
}
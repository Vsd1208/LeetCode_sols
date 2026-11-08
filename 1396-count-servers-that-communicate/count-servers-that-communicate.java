class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length,n=grid[0].length;
        int[] row_count = new int[m];
        int[] col_count = new int[n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    count++;
                    row_count[i]++;
                    col_count[j]++;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && row_count[i]==1 && col_count[j]==1) count--;
            }
        }
        return count;
    }
}
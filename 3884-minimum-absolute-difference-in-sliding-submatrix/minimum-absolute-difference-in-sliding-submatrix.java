class Solution {
    private int abs_diff(int[][] mat){
        HashSet<Integer> nums = new HashSet<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                nums.add(mat[i][j]);
            }
        }
        int[] arr = new int[nums.size()];
        int idx = 0;
        for (int num : nums) {
            arr[idx++] = num;
        }
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }
        return minDiff == Integer.MAX_VALUE ? 0 : minDiff;
    }
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length;
        int[][] ans = new int[m-k+1][n-k+1];
        for(int i=0;i<m-k+1;i++){
            for(int j=0;j<n-k+1;j++){
                int[][] sub = new int[k][k];
                for (int x = 0; x < k; x++) {
                    for (int y = 0; y < k; y++) {
                        sub[x][y] = grid[i + x][j + y];
                    }
                }
                ans[i][j] = abs_diff(sub);
            }
        }
        return ans;
    }
}
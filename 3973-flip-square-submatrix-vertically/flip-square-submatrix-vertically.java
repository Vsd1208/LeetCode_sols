class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for(int i=y;i<y+k;i++){
            int left = x,right=x+k-1;
            while(left<right){
                int temp = grid[left][i];
                grid[left][i]=grid[right][i];
                grid[right][i]=temp;
                left++;
                right--;
            }
        }
        return grid;
    }
}
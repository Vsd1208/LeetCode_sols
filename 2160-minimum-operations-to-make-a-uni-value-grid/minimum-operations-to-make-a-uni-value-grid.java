class Solution {
    public int minOperations(int[][] grid, int x) {
        int n= grid.length;
        int m=grid[0].length;
        int[] arr = new int[n*m];
        int k=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[k++]=grid[i][j];
            }
        }
        Arrays.sort(arr);
        int rem = arr[0] % x;
        for(int val : arr){
            if(val % x != rem) return -1;
        }
        int median = arr[arr.length/2];
        int ops = 0;
        for(int val : arr){
            ops += Math.abs(val - median) / x;
        }
        return ops;
    }
}
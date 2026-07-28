class Solution {
    int[][] spiral;
    public int[][] generateMatrix(int n) {
        spiral = new int[n][n];
        int num=1;
        int index = 0;
        while(index < (n+1)/2){
            for(int i=index;i<n-index;i++) spiral[index][i] = num++;
            for(int j=index+1;j<n-index;j++) spiral[j][n-index-1] = num++;
            if(n-index-1!=index){
                for(int i=n-index-2;i>=index;i--) spiral[n-index-1][i] = num++;
            }
            if(n-index-1!=index){
                for(int j=n-index-2;j>=index+1;j--) spiral[j][index] = num++;
            }
            index++;
        }
        return spiral;
    }
}
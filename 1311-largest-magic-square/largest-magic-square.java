class Solution {
    private boolean magicsquare(int[][] mat){
        int[] sums = new int[2 * mat.length + 2];
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat.length; j++){
                sums[i] += mat[i][j];                 
                sums[i + mat.length] += mat[j][i];
            }
        }
        int i = 0, j = 0;
        while(i < mat.length && j < mat.length){
            sums[2 * mat.length] += mat[i++][j++];
        }
        i = 0;
        j = mat.length - 1;
        while(i < mat.length && j >= 0){
            sums[2 * mat.length + 1] += mat[i++][j--];
        }
        for(int k = 0; k < sums.length - 1; k++){
            if(sums[k] != sums[k + 1])
                return false;
        }
        return true;
    }
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxSize = Math.min(m, n);
        for(int size = maxSize; size >= 1; size--){
            for(int i = 0; i + size <= m; i++){
                for(int j = 0; j + size <= n; j++){
                    int[][] mat = new int[size][size];
                    for(int r = 0; r < size; r++){
                        for(int c = 0; c < size; c++){
                            mat[r][c] = grid[i + r][j + c];
                        }
                    }
                    if(magicsquare(mat))
                        return size;
                }
            }
        }
        return 1;
    }
}
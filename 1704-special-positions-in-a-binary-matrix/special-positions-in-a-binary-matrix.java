class Solution {
    public int numSpecial(int[][] mat) {
        int count = 0;
        int m = mat.length;
        int n = mat[0].length;
        int i = 0;
        while (i < m) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    int ones = 0;
                    for (int col = 0; col < n; col++) {
                        if (mat[i][col] == 1) ones++;
                    }
                    for (int row = 0; row < m; row++) {
                        if (mat[row][j] == 1) ones++;
                    }
                    if (ones == 2) count++;
                }
            }
            i++;
        }
        return count;
    }
}
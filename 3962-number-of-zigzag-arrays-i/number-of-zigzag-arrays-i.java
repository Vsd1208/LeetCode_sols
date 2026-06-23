class Solution {
    public int zigZagArrays(int n, int l, int r) {

        int MOD = 1_000_000_007;
        int m = r - l + 1;

        long[][] dpUp = new long[n][m];
        long[][] dpDown = new long[n][m];

        // base case
        for(int i = 0; i < m; i++){
            dpUp[0][i] = 1;
            dpDown[0][i] = 1;
        }

        for(int i = 1; i < n; i++){

            long[] prefixUp = new long[m];
            long[] prefixDown = new long[m];

            prefixUp[0] = dpUp[i-1][0];
            prefixDown[0] = dpDown[i-1][0];

            for(int j = 1; j < m; j++){
                prefixUp[j] = (prefixUp[j-1] + dpUp[i-1][j]) % MOD;
                prefixDown[j] = (prefixDown[j-1] + dpDown[i-1][j]) % MOD;
            }

            for(int j = 0; j < m; j++){

                // UP: previous < current
                if(j > 0)
                    dpUp[i][j] = prefixDown[j-1];

                // DOWN: previous > current
                if(j < m-1)
                    dpDown[i][j] = (prefixUp[m-1] - prefixUp[j] + MOD) % MOD;
            }
        }

        long ans = 0;
        for(int j = 0; j < m; j++){
            ans = (ans + dpUp[n-1][j] + dpDown[n-1][j]) % MOD;
        }

        return (int)ans;
    }
}
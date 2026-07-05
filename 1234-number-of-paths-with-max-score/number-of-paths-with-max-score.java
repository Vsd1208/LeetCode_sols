// class Solution {
//     public int[] pathsWithMaxScore(List<String> board) {
//         int m = board.get(0).length();
//         int[][] mat = new int[m][m];
//         for(int i=0;i<m;i++){
//             for(int j=0;j<m;j++){
//                 if(board.get(i).charAt(j)=='S') mat[i][j]=0;
//                 else if(board.get(i).charAt(j)=='E') mat[i][j]=0;
//                 else if(board.get(i).charAt(j)=='X') mat[i][j]=-1;
//                 else mat[i][j]=Integer.valueOf((board.get(i).charAt(j));
//             }
//         }
//         int[][] dp = new int[m][4];
//         for(int i=0;i<m;i++) dp[0][i]=mat[i][j];
//         for(int j=0;j<m;j++) dp[i][0]=mat[i][j];
//         for(int i=0;i<m-1;i++){
//             for(int j=0;j<m-1;j++){
//                 dp[i][3]=0;
//                 for(int k=0;k<3;k++){
//                     if(k==0){
//                         dp[i][k]=Math.max(dp[i][k],dp[i][k]+mat[i+1][j]);
//                         dp[i][3]=Math.max(dp[i][k],dp[i][3]);
//                     }
//                     if(k==1){
//                         dp[i][k]=Math.max(dp[i][k],dp[i][k]+mat[i][j+1]);
//                         dp[i][3]=Math.max(dp[i][k],dp[i][3]);
//                     }
//                 }
//             }
//         }
//     }
// }
class Solution {

    static final int MOD = 1_000_000_007;

    public int[] pathsWithMaxScore(List<String> board) {

        int n = board.size();

        int[][] score = new int[n][n];
        int[][] ways = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(score[i], -1);
        }

        score[n - 1][n - 1] = 0;
        ways[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                if (board.get(i).charAt(j) == 'X')
                    continue;

                if (i == n - 1 && j == n - 1)
                    continue;

                int best = -1;
                int count = 0;

                int[][] dir = {{1,0},{0,1},{1,1}};

                for (int[] d : dir) {

                    int ni = i + d[0];
                    int nj = j + d[1];

                    if (ni >= n || nj >= n)
                        continue;

                    if (score[ni][nj] == -1)
                        continue;

                    if (score[ni][nj] > best) {

                        best = score[ni][nj];
                        count = ways[ni][nj];

                    } else if (score[ni][nj] == best) {

                        count = (count + ways[ni][nj]) % MOD;
                    }
                }

                if (best == -1)
                    continue;

                char ch = board.get(i).charAt(j);

                int val = 0;

                if (ch >= '1' && ch <= '9')
                    val = ch - '0';

                score[i][j] = best + val;
                ways[i][j] = count;
            }
        }

        if (ways[0][0] == 0)
            return new int[]{0, 0};

        return new int[]{score[0][0], ways[0][0]};
    }
}
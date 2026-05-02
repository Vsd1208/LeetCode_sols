// class Solution {
//     private void count_Tree(int start,int end,int count){
//         if(start==end) return;
//         else{
//             if(0<start){
//                 for(int i=0;i<start;i++)
                    
//             }
//             else{

//             }
//         }
//     }
//     public int numTrees(int n) {
//         int count=0;
//         count_Tree(0,n,count);
//     }
// }
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
class Solution {
    // private int ncr(int n,int r){
    //     long res = 1;
    //     for (int i = 1; i <= r; i++) {
    //         res = res * (n - r + i) / i;
    //     }
    //     return (int) res;
    // }
    // public int climbStairs(int n) {
    //     int k=n/2;
    //     int sum=0;
    //     for(int i=0;i<=k;i++){
    //         int q=ncr(n-i,i);
    //         sum+=q;
    //     }
    //     return sum;
    // }
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n+1];
        dp[1]=1;dp[2]=2;
        for(int i=3;i<=n;i++)
            dp[i]=(dp[i-1]+dp[i-2]);
        return dp[n];
    }
}
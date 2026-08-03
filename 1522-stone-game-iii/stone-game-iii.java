class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length,take1=0,take2=0,take3=0;
        int[] dp = new int[n+3];
        for(int i=n-1;i>=0;i--){
            take1 = stoneValue[i] - dp[i+1];
            take2 = Integer.MIN_VALUE;
            take3 = Integer.MIN_VALUE;
            if(i+1 < n) take2 = stoneValue[i]+stoneValue[i+1] - dp[i+2];
            if(i+2 < n) take3 = stoneValue[i]+stoneValue[i+1]+stoneValue[i+2] - dp[i+3];
            dp[i] = Math.max(take1,Math.max(take2,take3));
        }
        if(dp[0]>0) return "Alice";
        else if(dp[0]<0) return "Bob";
        else return "Tie";
    }
}
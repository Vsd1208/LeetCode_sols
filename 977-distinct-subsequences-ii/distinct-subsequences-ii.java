class Solution {
    public int distinctSubseqII(String s) {
        long MOD = 1_000_000_007;
        long[] dp = new long[26];
        long total = 0;
        
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            long add = (total + 1 - dp[i] + MOD) % MOD;
            dp[i] = (dp[i] + add) % MOD;
            total = (total + add) % MOD;
        }
        
        return (int) total;
    }
}
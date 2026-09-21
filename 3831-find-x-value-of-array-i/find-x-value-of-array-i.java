class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        // dp[r] stores the number of subarrays ending at the current position with product % k == r
        long[] dp = new long[k];
        
        for (final int num : nums) {
            long[] newDp = new long[k];
            final int numMod = num % k;
            
            // Start a new subarray with only the current element
            newDp[numMod] = 1;
            
            // Extend all previous subarrays
            for (int i = 0; i < k; ++i) {
                final int newMod = (int) (1L * i * numMod % k);
                newDp[newMod] += dp[i];
            }
            
            // Accumulate counts into the final answer array
            for (int i = 0; i < k; ++i) {
                ans[i] += newDp[i];
            }
            
            dp = newDp;
        }
        
        return ans;
    }
}
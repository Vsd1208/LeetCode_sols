class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int MOD = 1_000_000_007;

        // Precompute powers of 10 up to n
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        // sumD[i] stores the sum of digits in s[0...i-1]
        int[] sumD = new int[n + 1];
        // cntN0[i] stores the count of non-zero digits in s[0...i-1]
        int[] cntN0 = new int[n + 1];
        // p[i] stores the value formed by non-zero digits in s[0...i-1] modulo 10^9 + 7
        long[] p = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            int d = s.charAt(i - 1) - '0';
            sumD[i] = sumD[i - 1] + d;
            cntN0[i] = cntN0[i - 1] + (d > 0 ? 1 : 0);
            
            if (d > 0) {
                // If the current digit is non-zero, append it to the current construction
                p[i] = (p[i - 1] * 10 + d) % MOD;
            } else {
                // If zero, just carry forward the previous value
                p[i] = p[i - 1];
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int n0 = cntN0[r + 1] - cntN0[l];
            int sd = sumD[r + 1] - sumD[l];

            if (n0 == 0) {
                ans[i] = 0;
            } else {
                // Extract the segment [l, r] value:
                // x = (p[r+1] - p[l] * 10^(number of non-zero digits in the range)) % MOD
                long x = (p[r + 1] - (p[l] * pow10[n0]) % MOD + MOD) % MOD;
                ans[i] = (int) ((x * sd) % MOD);
            }
        }

        return ans;
    }
}
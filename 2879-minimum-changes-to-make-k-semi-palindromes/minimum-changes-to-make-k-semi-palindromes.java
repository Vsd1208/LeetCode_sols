
import java.util.*;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];
        int[][] dp = new int[n + 1][k + 1];

        for (int[] row : dp)
            Arrays.fill(row, 1000000);

        dp[0][0] = 0;

        // Calculate minimum changes for every substring
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int len = j - i + 1;
                cost[i][j] = Integer.MAX_VALUE;

                for (int d = 1; d < len; d++) {
                    if (len % d != 0) continue;

                    int count = 0;

                    for (int x = 0; x < d; x++) {
                        int left = i + x;
                        int right = j - d + 1 + x;

                        while (left < right) {
                            if (s.charAt(left) != s.charAt(right))
                                count++;

                            left += d;
                            right -= d;
                        }
                    }

                    cost[i][j] = Math.min(cost[i][j], count);
                }
            }
        }

        // DP to divide string into k parts
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int p = 0; p <= i - 2; p++) {
                    if (dp[p][j - 1] == 1000000)
                        continue;

                    dp[i][j] = Math.min(dp[i][j],
                        dp[p][j - 1] + cost[p][i - 1]);
                }
            }
        }

        return dp[n][k];
    }
}

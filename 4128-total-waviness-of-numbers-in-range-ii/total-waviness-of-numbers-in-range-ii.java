import java.util.*;

class Solution {
    // State: [index][prevDigit][secondPrevDigit][isTight][isStarted][valType]
    // valType: 0 for count, 1 for total sum of waviness
    private long[][][][][][] memo;

    public long totalWaviness(long num1, long num2) {
        return solve(String.valueOf(num2)) - solve(String.valueOf(num1 - 1));
    }

    private long solve(String N) {
        if (N.startsWith("-")) return 0;
        int len = N.length();
        // Reset memo: [len][11][11][2][2][2]
        memo = new long[len][11][11][2][2][2];
        for (long[][][][][] a : memo)
            for (long[][][][] b : a)
                for (long[][][] c : b)
                    for (long[][] d : c)
                        for (long[] e : d) Arrays.fill(e, -1);

        return dp(0, 10, 10, true, false, N)[1];
    }

    private long[] dp(int idx, int p1, int p2, boolean isTight, boolean isStarted, String N) {
        if (idx == N.length()) return new long[]{1, 0}; // {count, sum}

        int t = isTight ? 1 : 0;
        int s = isStarted ? 1 : 0;
        if (memo[idx][p1][p2][t][s][0] != -1) {
            return new long[]{memo[idx][p1][p2][t][s][0], memo[idx][p1][p2][t][s][1]};
        }

        long totalCount = 0;
        long totalSum = 0;
        int limit = isTight ? N.charAt(idx) - '0' : 9;

        for (int d = 0; d <= limit; d++) {
            boolean nextTight = isTight && (d == limit);
            boolean nextStarted = isStarted || (d > 0);
            
            int isWave = 0;
            // middle digit (p1) is a wave if it's strictly between p2 and current d
            if (isStarted && p1 < 10 && p2 < 10) {
                if ((p1 > p2 && p1 > d) || (p1 < p2 && p1 < d)) {
                    isWave = 1;
                }
            }

            long[] res = dp(idx + 1, nextStarted ? d : 10, isStarted ? p1 : 10, nextTight, nextStarted, N);
            
            totalCount += res[0];
            // Waviness = Sum of waviness in children + (1 if current digit is a wave * number of children)
            totalSum += res[1] + (isWave * res[0]);
        }

        memo[idx][p1][p2][t][s][0] = totalCount;
        memo[idx][p1][p2][t][s][1] = totalSum;
        return new long[]{totalCount, totalSum};
    }
}

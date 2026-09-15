// class Solution {

//     private boolean ispalindrome(String str) {
//         StringBuilder sb = new StringBuilder();
//         sb.append(str);
//         return str.equals(sb.reverse().toString());
//     }

//     private int solve(String s, int idx, int k) {

//         if (idx >= s.length()) return 0;

//         int skip = solve(s, idx + 1, k);
//         int take = 0;

//         for (int j = idx + k; j <= s.length(); j++) {

//             String str = s.substring(idx, j);

//             if (ispalindrome(str)) {
//                 take = Math.max(take, 1 + solve(s, j, k));
//             }
//         }

//         return Math.max(take, skip);
//     }

//     public int maxPalindromes(String s, int k) {
//         return solve(s, 0, k);
//     }
// }
class Solution {

    private int solve(String s, int idx, int k, int[] dp, boolean[][] pal) {

        if (idx >= s.length()) return 0;

        if (dp[idx] != -1) return dp[idx];

        int skip = solve(s, idx + 1, k, dp, pal);
        int take = 0;

        for (int j = idx + k - 1; j < s.length(); j++) {
            if (pal[idx][j]) {
                take = Math.max(take, 1 + solve(s, j + 1, k, dp, pal));
            }
        }

        return dp[idx] = Math.max(take, skip);
    }

    public int maxPalindromes(String s, int k) {

        int n = s.length();

        boolean[][] pal = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 2 || pal[i + 1][j - 1])) {
                    pal[i][j] = true;
                }
            }
        }

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(s, 0, k, dp, pal);
    }
}
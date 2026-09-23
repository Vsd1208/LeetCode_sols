class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        HashMap<String, Character> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf(i + 1), (char)('A' + i));
        }
        if (s.charAt(0) == '0') return 0;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            String one = s.substring(i - 1, i);
            String two = s.substring(i - 2, i);
            if (map.containsKey(one)) {
                dp[i] += dp[i - 1];
            }
            if (map.containsKey(two)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
}
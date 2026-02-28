class Solution {
    public int concatenatedBinary(int n) {
        int MOD = 1_000_000_007;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Integer.toBinaryString(i));
        }
        long result = 0;
        for (int i = 0; i < sb.length(); i++) {
            result = (result * 2 + (sb.charAt(i) - '0')) % MOD;
        }
        return (int) result;
    }
}
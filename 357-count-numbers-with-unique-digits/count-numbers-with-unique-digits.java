class Solution {
    private int count(int len, int index, boolean[] used) {
        if (index == len) return 1;
        int c = 0;
        for (int i = 0; i <= 9; i++) {
            if (used[i]) continue;
            if (index == 0 && i == 0) continue; // no leading zero
            used[i] = true;
            c += count(len, index + 1, used);
            used[i] = false;
        }
        return c;
    }
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int total = 1; // count "0"
        for (int len = 1; len <= n; len++) {
            total += count(len, 0, new boolean[10]);
        }
        return total;
    }
}
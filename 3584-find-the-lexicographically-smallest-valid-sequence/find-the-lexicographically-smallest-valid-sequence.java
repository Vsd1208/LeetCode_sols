class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] suffix = new int[n + 1];

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                suffix[i] = suffix[i + 1] + 1;
                j--;
            } else {
                suffix[i] = suffix[i + 1];
            }
        }

        int[] ans = new int[m];

        int pos = 0;
        int changed = 0;

        for (int i = 0; i < n && pos < m; i++) {

            if (word1.charAt(i) == word2.charAt(pos)) {
                ans[pos] = i;
                pos++;
            } 
            else if (changed == 0) {

                if (n - i - 1 >= m - pos - 1 &&
                    suffix[i + 1] >= m - pos - 1) {

                    ans[pos] = i;
                    pos++;
                    changed = 1;
                }
            }
        }

        if (pos != m)
            return new int[0];

        return ans;
    }
}
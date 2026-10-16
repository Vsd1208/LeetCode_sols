class Solution {
    public int characterReplacement(String s, int k) {
        int l = s.length();
        int[] freq = new int[26];
        int left = 0, max = 0, ans = 0;
        for (int right = 0; right < l; right++) {
            char ch = s.charAt(right);
            freq[ch - 'A']++;
            max = Math.max(max, freq[ch - 'A']);
            while ((right - left + 1) - max > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
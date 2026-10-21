class Solution {
    public int minOperations(String s) {
        int l = s.length();
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        StringBuilder sorted = new StringBuilder();
        for (int j = 0; j < 26; j++) {
            for (int k = 0; k < freq[j]; k++) {
                sorted.append((char) ('a' + j));
            }
        }
        if (s.equals(sorted.toString())) return 0;
        if (l == 2) return -1;
        char min = sorted.charAt(0);
        char max = sorted.charAt(l - 1);
        if (s.charAt(0) == min || s.charAt(l - 1) == max)
            return 1;
        for (int i = 1; i < l - 1; i++) {
            if (s.charAt(i) == min || s.charAt(i) == max)
                return 2;
        }
        return 3;
    }
}
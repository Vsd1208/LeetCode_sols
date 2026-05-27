import java.util.*;

class Solution {
    public String longestDupSubstring(String s) {
        int n = s.length();
        int left = 1, right = n - 1;
        String res = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String dup = search(s, mid);

            if (dup != null) {
                res = dup;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    private String search(String s, int len) {
        int n = s.length();

        long mod1 = 1_000_000_007L;
        long mod2 = 1_000_000_009L;
        long base = 256;

        long hash1 = 0, hash2 = 0;
        long power1 = 1, power2 = 1;
        for (int i = 0; i < len; i++) {
            power1 = (power1 * base) % mod1;
            power2 = (power2 * base) % mod2;
        }
        for (int i = 0; i < len; i++) {
            hash1 = (hash1 * base + s.charAt(i)) % mod1;
            hash2 = (hash2 * base + s.charAt(i)) % mod2;
        }

        HashSet<String> seen = new HashSet<>();
        seen.add(hash1 + "#" + hash2);

        for (int i = len; i < n; i++) {
            hash1 = (hash1 * base 
                    - s.charAt(i - len) * power1 % mod1 + mod1) % mod1;
            hash2 = (hash2 * base 
                    - s.charAt(i - len) * power2 % mod2 + mod2) % mod2;

            hash1 = (hash1 + s.charAt(i)) % mod1;
            hash2 = (hash2 + s.charAt(i)) % mod2;

            String key = hash1 + "#" + hash2;

            if (seen.contains(key)) {
                return s.substring(i - len + 1, i + 1);
            }

            seen.add(key);
        }

        return null;
    }
}
class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.put((long)x, freq.getOrDefault((long)x, 0) + 1);
        }
        int ans = 1;
        if (freq.containsKey(1L)) {
            int f = freq.get(1L);
            ans = Math.max(ans, (f % 2 == 0) ? f - 1 : f);
        }
        for (long x : freq.keySet()) {
            if (x == 1) continue;
            long cur = x;
            int len = 0;
            while (freq.containsKey(cur) && freq.get(cur) >= 2) {
                len += 2;
                if (cur > (long)1e9) break;
                cur = cur * cur;
            }
            if (freq.containsKey(cur)) {
                len++;
            } else {
                len--;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}
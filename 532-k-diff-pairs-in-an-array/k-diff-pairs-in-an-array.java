class Solution {
    public int findPairs(int[] nums, int k) {
        int count = 0;
        if (k == 0) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int n : nums) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
            for (int freq : map.values()) {
                if (freq > 1)
                    count++;
            }
            return count;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums)
            set.add(n);
        for (int n : set) {
            if (set.contains(n + k))
                count++;
        }
        return count;
    }
}
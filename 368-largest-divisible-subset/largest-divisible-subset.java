class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        int max = 1, idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                idx = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        while (idx != -1) {
            list.add(nums[idx]);
            idx = parent[idx];
        }
        Collections.reverse(list);
        return list;
    }
}
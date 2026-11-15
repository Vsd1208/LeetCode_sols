
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int min = Integer.MAX_VALUE;
        int[] pre = new int[n];
        pre[0] = nums.get(0);
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + nums.get(i);
        }
        for (int i = 0; i <= n - l; i++) {
            int left = i + l - 1;
            int right = Math.min(i + r - 1, n - 1);
            while (left <= right) {
                int sum = pre[left] - (i == 0 ? 0 : pre[i - 1]);
                if (sum > 0)
                    min = Math.min(min, sum);

                left++;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}

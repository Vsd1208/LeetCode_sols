class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] pre_sum = new int[n];
        pre_sum[0] = nums[0];
        pre_sum[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            pre_sum[i] = Math.max(nums[i] + pre_sum[i-2], pre_sum[i-1]);
        }
        return pre_sum[n-1];
    }
}
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        boolean[] check = new boolean[n];
        Arrays.fill(check, true);
        int i = 0, sum = 0, minSum = 0, total = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++)
            max = Math.max(max, nums[j]);
        while (check[i]) {
            sum += nums[i];
            minSum += nums[i];
            total += nums[i];
            max = Math.max(max, sum);
            min = Math.min(min, minSum);
            if (sum < 0) sum = 0;
            if (minSum > 0) minSum = 0;
            check[i] = false;
            i = (i + 1) % n;
        }
        if (max < 0) return max;
        return Math.max(max, total - min);
    }
}
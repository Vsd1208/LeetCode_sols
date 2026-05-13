class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];

            int low = Math.min(a, b);
            int high = Math.max(a, b);
            int sum = a + b;

            diff[2] += 2;

            diff[low + 1] -= 1;
            diff[high + limit + 1] += 1;

            diff[sum] -= 1;
            diff[sum + 1] += 1;
        }

        int res = Integer.MAX_VALUE;
        int curr = 0;

        for (int i = 2; i <= 2 * limit; i++) {
            curr += diff[i];
            res = Math.min(res, curr);
        }

        return res;
    }
}
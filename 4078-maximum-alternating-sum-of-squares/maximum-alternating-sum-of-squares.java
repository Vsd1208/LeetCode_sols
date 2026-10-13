class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] max = new long[n];
        long[] sums = new long[n];
        for (int i = 0; i < n; i++) {
            max[i] = (long) nums[i] * nums[i];
        }
        Arrays.sort(max);

        int k1 = 0, k2 = 1, i = n - 1;

        for (i = n - 1; i >= n / 2 && k1 < n; i--) {
            sums[k1] = max[i];
            k1 += 2;
        }

        while (i >= 0 && k2 < n) {
            sums[k2] = max[i];
            i--;
            k2 += 2;
        }

        long sum = 0;

        for (int q = 0; q < n; q++) {
            if (q % 2 == 0)
                sum += sums[q];
            else
                sum -= sums[q];
        }

        return sum;
    }
}
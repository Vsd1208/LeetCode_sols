class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            int[] sub = Arrays.copyOfRange(nums, i, i + k);
            int diff = sub[k - 1] - sub[0];
            if (diff < min) {
                min = diff;
            }
        }
        return min;
    }
}
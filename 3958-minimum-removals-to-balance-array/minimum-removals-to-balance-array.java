class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < n; right++) {
            while ((long) nums[left] * k < nums[right]) {
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return n - maxLen;
    }
}



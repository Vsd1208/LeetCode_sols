
class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        // Change two smallest elements
        min = Math.min(min, nums[n - 1] - nums[2]);
        // Change two largest elements
        min = Math.min(min, nums[n - 3] - nums[0]);
        // Change one smallest and one largest
        min = Math.min(min, nums[n - 2] - nums[1]);
        return min;
    }
}

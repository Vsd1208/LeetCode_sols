class Solution {
    public int minimumCost(int[] nums) {
        int sum=nums[0];
        int[] min = Arrays.copyOfRange(nums,1,nums.length);
        Arrays.sort(min);
        sum+=min[0]+min[1];
        return sum;
    }
}
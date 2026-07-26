class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int max=0,n=nums.length;
        if(nums[0]<0 && nums[1]<0) max = nums[0]*nums[1]*nums[n-1];
        return Math.max(max,nums[n-1]*nums[n-2]*nums[n-3]);
    }
}
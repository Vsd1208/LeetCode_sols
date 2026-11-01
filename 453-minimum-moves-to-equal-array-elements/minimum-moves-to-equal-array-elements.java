class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++) min=Math.min(nums[i],min);
        int count=0;
        for(int n:nums){
            count+=(n-min);
        }
        return count;
    }
}
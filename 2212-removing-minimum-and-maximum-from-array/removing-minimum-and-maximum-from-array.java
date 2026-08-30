class Solution {
    public int minimumDeletions(int[] nums) {
        if(nums.length==1) return 1;
        int l = nums.length;
        int min_idx = 0,min=Integer.MAX_VALUE,max_idx = 0,max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min){
                min=nums[i];
                min_idx=i;
            }
            if(nums[i]>max){
                max=nums[i];
                max_idx=i;
            }
        }
        int minLeft=min_idx+1;
        int minRight=l-min_idx;
        int maxLeft=max_idx+1;
        int maxRight=l-max_idx;
        int ans=Math.min(Math.min(Math.max(minLeft,maxLeft),Math.max(minRight,maxRight)),Math.min(minLeft+maxRight,maxLeft+minRight));
        return ans;
    }
}
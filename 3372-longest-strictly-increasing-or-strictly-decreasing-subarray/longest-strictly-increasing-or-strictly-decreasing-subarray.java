class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max = 1,prev = nums[0],len=1;
        for(int i=1;i<nums.length;i++){
            if(prev<nums[i]) max++;
            else max=1;
            len=Math.max(max,len);
            prev=nums[i];
        }
        int max1=1;
        prev=nums[0];
        for(int i=1;i<nums.length;i++){
            if(prev>nums[i]) max1++;
            else max1=1;
            len=Math.max(max1,len);
            prev=nums[i];
        }
        if(max==0 && max1==0) return 1;
        else return len;
    }
}
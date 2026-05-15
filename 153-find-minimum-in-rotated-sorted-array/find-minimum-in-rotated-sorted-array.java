class Solution {
    public int findMin(int[] nums) {
        int left=0,right=nums.length-1,min=nums[0];
        while(left<=right){
            if(nums[left]<min)
               min=nums[left];
            if(nums[right]<min)
                min=nums[right];
            left++;
            right--;
        }
        return min;
    }
}
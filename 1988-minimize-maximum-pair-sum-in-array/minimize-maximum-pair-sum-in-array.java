class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max=Integer.MIN_VALUE;
        int left=0,right=nums.length-1;
        while(left<=right){
            if(max<(nums[left]+nums[right]))
                max=nums[left]+nums[right];
            left++;
            right--;
        }
        return max;
    }
}
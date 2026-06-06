class Solution {
    public int[] leftRightDifference(int[] nums) {
        int rightsum=0,leftsum=0;
        int[] arr = new int[nums.length];
        for(int i=0;i<nums.length;i++)
            rightsum+=nums[i];
        for(int i=0;i<nums.length;i++){
            rightsum-=nums[i];
            arr[i]=Math.abs(leftsum-rightsum);
            leftsum+=nums[i];
        }
        return arr;
    }
}
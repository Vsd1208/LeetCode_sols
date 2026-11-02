class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length,mid=0,count=0;
        if(n%2!=0) mid=n/2;
        else mid=n/2;
        for(int i=0;i<n;i++){
            count+=Math.abs(nums[i]-nums[mid]);
        }
        return count;
    }
}
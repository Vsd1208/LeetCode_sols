class Solution {
    private int digit_sum(int digit){
        int sum=0,rem=0;
        while(digit>0){
            rem=digit%10;
            digit/=10;
            sum+=rem;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(i==digit_sum(nums[i])) return i;
        }
        return -1;
    }
}
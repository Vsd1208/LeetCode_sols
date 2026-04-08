class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length==1) return (double)nums[0]/k;
        double max_avg=Double.NEGATIVE_INFINITY;
        for(int i=0;i<=nums.length-k;i++){
            int sum=0;
            for(int j=i;j<i+k;j++){
                sum+=nums[j];
            }
            max_avg=Math.max(max_avg,(double)sum/k);
        }
        return max_avg;
    }
}
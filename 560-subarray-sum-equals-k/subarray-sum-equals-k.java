class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length,count=0;
        int[] pre_sum = new int[n];
        pre_sum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pre_sum[i]=pre_sum[i-1]+nums[i];
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(i==0){
                    if(pre_sum[j]==k) count++;
                }
                else{
                    if(pre_sum[j]-pre_sum[i-1]==k) count++;
                }
            }
        }
        return count;
    }
}
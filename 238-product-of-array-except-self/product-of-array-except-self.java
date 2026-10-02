class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] pre_pro = new int[n];
        int[] suf_pro = new int[n];
        pre_pro[0]=nums[0];
        suf_pro[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            pre_pro[i]=pre_pro[i-1]*nums[i];
            suf_pro[n-i-1]=suf_pro[n-i]*nums[n-i-1];
        }
        nums[0]=suf_pro[1];
        nums[n-1]=pre_pro[n-2];
        for(int i=1;i<n-1;i++){
            nums[i]=pre_pro[i-1]*suf_pro[i+1];
        }
        return nums;
    }
}
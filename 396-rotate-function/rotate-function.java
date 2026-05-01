// class Solution {
//     private int max = Integer.MIN_VALUE;
//     private void rotatesum(int[] nums,int count){
//         if(count>=nums.length) return;
//         int sum=0;
//         for(int i=0;i<nums.length;i++)
//             sum+=(i*nums[i]);
//         if(max<=sum) max=sum;
//         int val = nums[nums.length - 1];
//         for(int i = nums.length - 1; i > 0; i--) {
//             nums[i] = nums[i - 1];
//         }
//         nums[0] = val;
//         rotatesum(nums,count+1);
//     }
//     public int maxRotateFunction(int[] nums) {
//         rotatesum(nums,0);
//         return max;
//     }
// }
class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int f = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            f += i * nums[i];
        }
        int max = f;
        for(int k = 1; k < n; k++) {
            f = f + sum - n * nums[n - k];
            max = Math.max(max, f);
        }
        return max;
    }
}
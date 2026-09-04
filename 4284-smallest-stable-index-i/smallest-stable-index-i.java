// class Solution {
//     public int firstStableIndex(int[] nums, int k) {
//         int[] min_val = new int[nums.length];
//         int min = Integer.MAX_VALUE,max=Integer.MIN_VALUE;
//         for(int i=0;i<nums.length;i++){
//             min = Math.min(min,nums[i]);
//         }
//         for(int i=0;i<nums.length;i++){
//             min_val[i]=min;
//             if(nums[i]<=min){
//                 for(int j=i;j<nums.length;j++)
//                     min_val[i]=Math.min(min_val[i],nums[j]);
//             }
//         }
//         int index=0,stable=0;
//         for(int i=0;i<nums.length;i++){
//             max=Math.max(max,nums[i]);
//             if(max-min_val[i]<=k){
//                 if(stable<max-min_val[i]){
//                     stable=max-min_val[i];
//                     index=i;
//                 }
//             }
//         }
//         return index;
//     }
// }
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] min_val = new int[nums.length];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            min = Math.min(min, nums[i]);
        }
        min_val[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            min_val[i] = Math.min(nums[i], min_val[i + 1]);
        }
        int index = -1;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            if(max - min_val[i] <= k){
                index = i;
                break;
            }
        }
        return index;
    }
}
// class Solution {
//     public int minSubArrayLen(int target, int[] nums) {
//         int[] pre = new int[nums.length];
//         pre[0]=nums[0];
//         for(int i=1;i<nums.length;i++){
//             pre[i]=pre[i-1]+nums[i];
//         }
//         int min=Integer.MAX_VALUE;
//         for(int i=0;i<nums.length;i++){
//             for(int j=i;j<nums.length;j++){
//                 int sum;
//                 if(i == 0)
//                     sum = pre[j];
//                 else
//                     sum = pre[j] - pre[i - 1];

//                 if(sum >= target){
//                     min = Math.min(min, j - i + 1);
//                 }
//             }
//         }
//         if(min==Integer.MAX_VALUE) return 0;
//         else return min;
//     }
// }
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while(sum >= target){
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        if(min == Integer.MAX_VALUE)
            return 0;
        return min;
    }
}
// class Solution {
//     public int[] constructTransformedArray(int[] nums) {
//         int[] result = new int[nums.length];

//         for (int i = 0; i < nums.length; i++) {

//             if (nums[i] > 0) {
//                 if (i + nums[i] < nums.length)
//                     result[i] = nums[i + nums[i]];
//                 else {
//                     int k = i + nums[i] - nums.length;
//                     result[i] = nums[k];
//                 }
//             }

//             else if (nums[i] < 0) {
//                 if (i - Math.abs(nums[i]) >= 0)
//                     result[i] = nums[i - Math.abs(nums[i])];
//                 else {
//                     int k = (i - Math.abs(nums[i]) + nums.length) % nums.length;
//                     result[i] = nums[k];
//                 }
//             }

//             else {
//                 result[i] = nums[i];
//             }
//         }
//         return result;
//     }
// }
class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int jump = nums[i];
            int idx = (i + jump) % n;
            if (idx < 0) idx += n;
            result[i] = nums[idx];
        }
        return result;
    }
}

//my approach with two loops
// class Solution {
//     public boolean checkSubarraySum(int[] nums, int k) {
//         int n = nums.length;
//         if(n < 2) return false;
//         int[] pre_sum = new int[n];
//         pre_sum[0] = nums[0];
//         for(int i = 1; i < n; i++){
//             pre_sum[i] = nums[i] + pre_sum[i - 1];
//         }
//         for(int i = 0; i < n; i++){
//             for(int j = i + 1; j < n; j++){
//                 int sum;
//                 if(i == 0) sum = pre_sum[j];
//                 else sum = pre_sum[j] - pre_sum[i - 1];
//                 if(sum % k == 0) return true;
//             }
//         }
//         return false;
//     }
// }
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n < 2) return false;
        int[] pre_sum = new int[n];
        pre_sum[0] = nums[0];
        for(int i = 1; i < n; i++){
            pre_sum[i] = nums[i] + pre_sum[i - 1];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < n; i++){
            int rem = pre_sum[i] % k;
            if(map.containsKey(rem)){
                if(i - map.get(rem) >= 2) return true;
            }
            else{
                map.put(rem, i);
            }
        }
        return false;
    }
}
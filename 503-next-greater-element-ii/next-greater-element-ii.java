// class Solution {
//     public int[] nextGreaterElements(int[] nums) {
//         int[] grt = new int[nums.length];
//         for(int i=0;i<nums.length-1;i++){
//             if(nums[i]<nums[i+1]) grt[i]=nums[i+1];
//             else{
//                 int temp=grt[i];
//                 for(int j=i+1;j<nums.length;j++){
//                     if(nums[i]<nums[j]){
//                         grt[i]=nums[j];
//                         break;
//                     }
//                 }
//                 if(grt[i]==temp){
//                     if(grt[i-1]>nums[i])
//                         grt[i]=grt[i-1];
//                     else
//                         grt[i]=-1;
//                 }
//             }
//         }

//         return grt;
//     }
// }
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return result;
    }
}
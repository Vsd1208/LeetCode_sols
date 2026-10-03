// class Solution {
//     public int findMaxLength(int[] nums) {
//         int n=nums.length,max=0;
//         int[] pre_sum = new int[n];
//         if(nums[0]==0) pre_sum[0]=-1;
//         else pre_sum[0]=1;
//         for(int i=1;i<n;i++){
//             if(nums[i]==0) pre_sum[i]=pre_sum[i-1] + -1;
//             else pre_sum[i]=pre_sum[i-1]+1;
//         }
//         for(int i=0;i<n;i++){
//             for(int j=i;j<n;j++){
//                 if((i==0?pre_sum[j]:pre_sum[j]-pre_sum[i-1])==0){
//                     max=Math.max(max,j-i+1);
//                 }
//             }
//         }
//         return max;
//     }
// }

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length, max = 0;
        int[] pre_sum = new int[n];
        if(nums[0] == 0) pre_sum[0] = -1;
        else pre_sum[0] = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] == 0) pre_sum[i] = pre_sum[i - 1] - 1;
            else pre_sum[i] = pre_sum[i - 1] + 1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < n; i++){
            if(map.containsKey(pre_sum[i])){
                max = Math.max(max, i - map.get(pre_sum[i]));
            }
            else{
                map.put(pre_sum[i], i);
            }
        }
        return max;
    }
}
// class Solution {
//     public int minimumDistance(int[] nums) {
//         int min = Integer.MAX_VALUE;
//         HashMap<Integer, List<Integer>> map = new HashMap<>();
//         for(int i = 0; i < nums.length; i++){
//             if(!map.containsKey(nums[i])){
//                 List<Integer> val = new ArrayList<>();
//                 val.add(i);
//                 map.put(nums[i], val);
//             } else {
//                 List<Integer> val = map.get(nums[i]);
//                 val.add(i);
//             }
//         }
//         for(int i=0;i<nums.length;i++){
//             List<Integer> val = map.get(nums[i]);
//             if(val.size()<3) continue;
//             for(int j=0;j<=val.size()-3;j++){
//                 min = Math.min(min,
//                 Math.abs(val.get(j) - val.get(j+1)) +
//                 Math.abs(val.get(j+1) - val.get(j+2)) +
//                 Math.abs(val.get(j) - val.get(j+2))
//             );
//             }
//         }
//         return min == Integer.MAX_VALUE ? -1 : min;
//     }
// }
class Solution {
    public int minimumDistance(int[] nums) {
        int min = Integer.MAX_VALUE;
        HashMap<Integer, int[]> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(!map.containsKey(num)){
                map.put(num, new int[]{-1, -1, -1});
            }
            int[] arr = map.get(num);
            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = i;
            if(arr[0] != -1){
                int a = arr[0];
                int c = arr[2];
                min = Math.min(min, 2 * (c - a));
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
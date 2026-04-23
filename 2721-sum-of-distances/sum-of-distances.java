// class Solution {
//     public long[] distance(int[] nums) {
//         long[] arrs = new long[nums.length];
//         HashMap<Integer,List<Integer>> map = new HashMap<>();
//         for(int i = 0; i < nums.length; i++){
//             if(!map.containsKey(nums[i])){
//                 map.put(nums[i], new ArrayList<>());
//             }
//             map.get(nums[i]).add(i);
//         }
//         for(int i=0;i<nums.length;i++){
//             List<Integer> arr = map.get(nums[i]);
//             int j=0;
//             while(j<arr.size()){
//                 arrs[i]+=Math.abs(i-arr.get(j));
//                 j++;
//             }
//         }
//         return arrs;
//     }
// }
class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (List<Integer> list : map.values()) {
            int size = list.size();
            long[] prefix = new long[size];
            prefix[0] = list.get(0);
            for (int i = 1; i < size; i++) {
                prefix[i] = prefix[i - 1] + list.get(i);
            }
            for (int i = 0; i < size; i++) {
                int idx = list.get(i);
                long left = (long) idx * i - (i > 0 ? prefix[i - 1] : 0);
                long right = (prefix[size - 1] - prefix[i]) - (long) idx * (size - i - 1);
                res[idx] = left + right;
            }
        }
        return res;
    }
}
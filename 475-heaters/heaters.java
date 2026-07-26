// class Solution {
//     public int findRadius(int[] houses, int[] heaters) {
//         HashSet<Integer> set = new HashSet<>();
//         for(int i=0;i<houses.length;i++) set.add(houses[i]);
//         for(int i=0;i<heaters.length;i++){
//             if(!set.contains(heaters[i])) set.add(heaters[i]);
//         }
//         List<Integer> f_arr = new ArrayList<>();
//         Collections.sort(f_arr);
//         for(int val:set) f_arr.add(val);
//         int[] min = new int[f_arr.size()];
//         for(int i=0;i<f_arr.size();i++){
//             min[i]=Integer.MAX_VALUE;
//             for(int j=0;j<heaters.length;j++){
//                 min[i] = Math.min(min[i],Math.abs(f_arr.get(i)-heaters[j]));
//             }
//         }
//         int max = 0;
//         for(int i=0;i<heaters.length;i++) max=Math.max(max,min[i]);
//         return max;
//     }
// }
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int ans = 0;

        for (int house : houses) {
            int best = Integer.MAX_VALUE;

            for (int heater : heaters) {
                best = Math.min(best, Math.abs(house - heater));
            }

            ans = Math.max(ans, best);
        }

        return ans;
    }
}
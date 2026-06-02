// class Solution {
//     public int earliestFinishTime(int[] landStartTime, int[] landDuration,int[] waterStartTime, int[] waterDuration) {
//         int min_time = Integer.MAX_VALUE;
//         HashMap<Integer,Integer> wd = new HashMap<>();
//         for(int i = 0; i < waterStartTime.length; i++){
//             if(!wd.containsKey(waterStartTime[i]))
//                 wd.put(waterStartTime[i], waterStartTime[i] + waterDuration[i]);
//             else
//                 wd.put(waterStartTime[i],Math.min(wd.get(waterStartTime[i]),waterStartTime[i] + waterDuration[i]));
//         }
//         Arrays.sort(waterStartTime);
//         for(int i = 0; i < landStartTime.length; i++){
//             int landEnd = landStartTime[i] + landDuration[i];
//             int start = 0, end = waterStartTime.length - 1;
//             int idx = waterStartTime.length;
//             while(start <= end){
//                 int mid = start + (end - start) / 2;
//                 if(waterStartTime[mid] >= landEnd){
//                     idx = mid;
//                     end = mid - 1;
//                 } else {
//                     start = mid + 1;
//                 }
//             }
//             if(idx < waterStartTime.length){
//                 int ws = waterStartTime[idx];
//                 min_time = Math.min(min_time, wd.get(ws));
//             }
//             if(idx > 0){
//                 int ws = waterStartTime[idx - 1];
//                 int duration = wd.get(ws) - ws;
//                 int finish = landEnd + duration;
//                 min_time = Math.min(min_time, finish);
//             }
//             for(int j = 0; j < waterStartTime.length; j++){
//                 int ws = waterStartTime[j];
//                 int waterEnd = wd.get(ws);

//                 int startLand = Math.max(landStartTime[i], waterEnd);
//                 int finish = startLand + landDuration[i];

//                 min_time = Math.min(min_time, finish);
//             }
//         }

//         return min_time;
//     }
// }
// import java.util.*;

public class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {
        int landFirst = solve(landStartTime, landDuration,
                              waterStartTime, waterDuration);

        // water → land
        int waterFirst = solve(waterStartTime, waterDuration,
                               landStartTime, landDuration);

        return Math.min(landFirst, waterFirst);
    }

    private int solve(int[] firstStart, int[] firstDuration,
                      int[] secondStart, int[] secondDuration) {

        // 🔹 Step 1: find earliest finishing first ride
        int minFirstEnd = Integer.MAX_VALUE;
        for (int i = 0; i < firstStart.length; i++) {
            minFirstEnd = Math.min(minFirstEnd,
                                   firstStart[i] + firstDuration[i]);
        }

        // 🔹 Step 2: try all second rides
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < secondStart.length; i++) {
            int start = Math.max(minFirstEnd, secondStart[i]);
            int finish = start + secondDuration[i];
            ans = Math.min(ans, finish);
        }

        return ans;
    }
}
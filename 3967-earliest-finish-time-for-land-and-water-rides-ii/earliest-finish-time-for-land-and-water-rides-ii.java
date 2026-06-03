class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int landFirst = solve(landStartTime, landDuration,
                              waterStartTime, waterDuration);
        int waterFirst = solve(waterStartTime, waterDuration,
                               landStartTime, landDuration);

        return Math.min(landFirst, waterFirst);
    }
    private int solve(int[] firstStart, int[] firstDuration,
                      int[] secondStart, int[] secondDuration) {
        //find earliest finishing first ride
        int minFirstEnd = Integer.MAX_VALUE;
        for (int i = 0; i < firstStart.length; i++) {
            minFirstEnd = Math.min(minFirstEnd,
                                   firstStart[i] + firstDuration[i]);
        }
        //try all second rides
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < secondStart.length; i++) {
            int start = Math.max(minFirstEnd, secondStart[i]);
            int finish = start + secondDuration[i];
            ans = Math.min(ans, finish);
        }

        return ans;
    }
}
class Solution {
    // private boolean completion(int[] gas, int[] cost, int index) {
    //     int fuel = 0;
    //     int n = gas.length;
    //     for (int i = 0; i < n; i++) {
    //         int k = (index + i) % n;   
    //         fuel += gas[k];
    //         fuel -= cost[k];
    //         if (fuel < 0)
    //             return false;
    //     }
    //     return true;
    // }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // for (int i = 0; i < gas.length; i++) {
        //     if (completion(gas, cost, i))
        //         return i;
        // }
        // return -1;
        int total = 0;
        int tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}
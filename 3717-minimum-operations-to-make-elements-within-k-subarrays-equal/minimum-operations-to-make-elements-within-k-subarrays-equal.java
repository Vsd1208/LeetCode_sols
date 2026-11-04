import java.util.*;

class Solution {

    class WindowMedian {
        TreeMap<Integer, Integer> low = new TreeMap<>();
        TreeMap<Integer, Integer> high = new TreeMap<>();

        int lowSize = 0, highSize = 0;
        long lowSum = 0, highSum = 0;

        private void addMap(TreeMap<Integer, Integer> map, int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        private void removeMap(TreeMap<Integer, Integer> map, int val) {
            int count = map.get(val);

            if (count == 1) {
                map.remove(val);
            } else {
                map.put(val, count - 1);
            }
        }

        private void balance() {
            while (lowSize > highSize + 1) {
                int val = low.lastKey();

                removeMap(low, val);
                lowSize--;
                lowSum -= val;

                addMap(high, val);
                highSize++;
                highSum += val;
            }

            while (lowSize < highSize) {
                int val = high.firstKey();

                removeMap(high, val);
                highSize--;
                highSum -= val;

                addMap(low, val);
                lowSize++;
                lowSum += val;
            }
        }

        void add(int val) {
            if (low.isEmpty() || val <= low.lastKey()) {
                addMap(low, val);
                lowSize++;
                lowSum += val;
            } else {
                addMap(high, val);
                highSize++;
                highSum += val;
            }

            balance();
        }

        void remove(int val) {
            if (low.containsKey(val)) {
                removeMap(low, val);
                lowSize--;
                lowSum -= val;
            } else {
                removeMap(high, val);
                highSize--;
                highSum -= val;
            }

            balance();
        }

        long getCost() {
            long median = low.lastKey();

            return median * lowSize - lowSum
                 + highSum - median * highSize;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        // Step 1: Calculate the minimum cost of every window
        WindowMedian wm = new WindowMedian();

        for (int i = 0; i < x; i++) {
            wm.add(nums[i]);
        }

        long[] cost = new long[n - x + 1];

        cost[0] = wm.getCost();

        for (int i = x; i < n; i++) {
            wm.remove(nums[i - x]);
            wm.add(nums[i]);

            cost[i - x + 1] = wm.getCost();
        }

        // Step 2: DP to select k non-overlapping windows
        long INF = Long.MAX_VALUE / 2;

        long[][] dp = new long[k + 1][n + 1];

        for (long[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {

                if (dp[j][i] == INF) {
                    continue;
                }

                // Skip current position
                dp[j][i + 1] = Math.min(
                    dp[j][i + 1],
                    dp[j][i]
                );

                // Select window starting at i
                if (j < k && i + x <= n) {
                    dp[j + 1][i + x] = Math.min(
                        dp[j + 1][i + x],
                        dp[j][i] + cost[i]
                    );
                }
            }
        }

        return dp[k][n];
    }
}
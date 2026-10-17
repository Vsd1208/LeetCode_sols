class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length, swap = 0;
        Integer[] str_num = new Integer[n];

        for (int i = 0; i < n; i++) {
            str_num[i] = nums[i];
        }

        Arrays.sort(str_num, (a, b) -> {
            int sum1 = 0, sum2 = 0;
            int x = a, y = b;

            while (x > 0) {
                sum1 += x % 10;
                x /= 10;
            }

            while (y > 0) {
                sum2 += y % 10;
                y /= 10;
            }

            if (sum1 != sum2) return sum1 - sum2;
            return a - b;
        });

        Map<Integer, Queue<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(str_num[i], k -> new LinkedList<>()).offer(i);
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] || nums[i] == str_num[i]) continue;

            int j = i, cycle = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = map.get(nums[j]).poll();
                cycle++;
            }

            if (cycle > 0) swap += cycle - 1;
        }

        return swap;
    }
}
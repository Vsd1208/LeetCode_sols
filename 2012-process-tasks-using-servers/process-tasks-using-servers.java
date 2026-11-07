
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];

        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
        );

        // {finishTime, serverIndex}
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0])
                    return Long.compare(a[0], b[0]);
                return Long.compare(a[1], b[1]);
            }
        );

        for (int i = 0; i < n; i++) {
            available.offer(new int[]{servers[i], i});
        }

        long time = 0;

        for (int i = 0; i < m; i++) {

            time = Math.max(time, i);

            // Release all servers that have finished
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] curr = busy.poll();
                int idx = (int) curr[1];

                available.offer(new int[]{servers[idx], idx});
            }

            // Wait until a server becomes available
            if (available.isEmpty()) {
                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    long[] curr = busy.poll();
                    int idx = (int) curr[1];

                    available.offer(new int[]{servers[idx], idx});
                }
            }

            int[] server = available.poll();

            ans[i] = server[1];

            busy.offer(new long[]{
                time + tasks[i],
                server[1]
            });
        }

        return ans;
    }
}

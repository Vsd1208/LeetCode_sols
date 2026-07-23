class Solution {
    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++)
            squares.add(i * i);
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n + 1];
        q.offer(n);
        vis[n] = true;
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            while (size-- > 0) {
                int curr = q.poll();
                for (int sq : squares) {
                    if (curr == sq)
                        return level;
                    if (curr < sq)
                        break;
                    int next = curr - sq;
                    if (!vis[next]) {
                        vis[next] = true;
                        q.offer(next);
                    }
                }
            }
        }
        return level;
    }
}
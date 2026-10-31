class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (!adj.get(u).isEmpty() && !adj.get(v).isEmpty() && isConnected(adj, u, v, n)) {
                return edge;
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return new int[0];
    }
    private boolean isConnected(List<List<Integer>> adj, int start, int target, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == target) {
                return true;
            }
            for (int neighbor : adj.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
        return false;
    }
}
class Solution {

    private int intersect(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();

        for (int x : a)
            set.add(x);

        int count = 0;
        HashSet<Integer> seen = new HashSet<>();

        for (int x : b) {
            if (!seen.contains(x) && set.contains(x)) {
                count++;
                seen.add(x);
            }
        }

        return count;
    }

    private void dfs(int node, List<Integer>[] graph, boolean[] vis) {
        vis[node] = true;

        for (int next : graph[node]) {
            if (!vis[next]) {
                dfs(next, graph, vis);
            }
        }
    }

    public int numberOfComponents(int[][] properties, int k) {

        int n = properties.length;

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        // Build graph
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if (intersect(properties[i], properties[j]) >= k) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        boolean[] vis = new boolean[n];

        int components = 0;

        for (int i = 0; i < n; i++) {

            if (!vis[i]) {
                components++;
                dfs(i, graph, vis);
            }
        }

        return components;
    }
}
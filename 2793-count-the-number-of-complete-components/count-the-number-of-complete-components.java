import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // Build the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeComponents = 0;

        // Traverse each component
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, adj, visited, component);
                
                // For a component with V vertices to be complete,
                // it must have exactly V * (V - 1) / 2 edges.
                // Sum of degrees in a component = 2 * edges.
                // So, we check if Sum of degrees = V * (V - 1).
                long vCount = component.size();
                long degreeSum = 0;
                for (int node : component) {
                    degreeSum += adj.get(node).size();
                }
                
                if (degreeSum == vCount * (vCount - 1)) {
                    completeComponents++;
                }
            }
        }
        
        return completeComponents;
    }

    private void dfs(int u, List<List<Integer>> adj, boolean[] visited, List<Integer> component) {
        visited[u] = true;
        component.add(u);
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, adj, visited, component);
            }
        }
    }
}
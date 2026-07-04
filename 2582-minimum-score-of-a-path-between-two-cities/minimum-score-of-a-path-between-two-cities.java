import java.util.*;

class Solution {
    public int minScore(int n, int[][] roads) {
        // Build adjacency list storing [neighbor, distance]
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] road : roads) {
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }
        
        int minDistance = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        // Start BFS from city 1
        queue.offer(1);
        visited[1] = true;
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            
            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int dist = edge[1];
                
                // Update the global minimum distance found in this component
                minDistance = Math.min(minDistance, dist);
                
                // Continue traversal if not visited
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
        
        return minDistance;
    }
}
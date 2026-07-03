import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        TreeSet<Integer> uniqueCosts = new TreeSet<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], cost = edge[2];
            // Path only valid if endpoints are online
            if (online[u] && online[v]) {
                adj.get(u).add(new int[]{v, cost});
                uniqueCosts.add(cost);
            }
        }
        
        List<Integer> sortedCosts = new ArrayList<>(uniqueCosts);
        int low = 0, high = sortedCosts.size() - 1;
        int result = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int threshold = sortedCosts.get(mid);
            
            if (hasPath(n, adj, threshold, k)) {
                result = threshold;
                low = mid + 1; // Try for a larger minimum
            } else {
                high = mid - 1;
            }
        }
        
        return result;
    }
    
    private boolean hasPath(int n, List<List<int[]>> adj, int threshold, long k) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        
        dist[0] = 0;
        pq.offer(new long[]{0, 0});
        
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int u = (int) curr[0];
            long d = curr[1];
            
            if (d > dist[u]) continue;
            if (u == n - 1) return d <= k;
            
            for (int[] edge : adj.get(u)) {
                int v = edge[0], cost = edge[1];
                if (cost >= threshold && dist[u] + cost < dist[v]) {
                    dist[v] = dist[u] + cost;
                    pq.offer(new long[]{v, dist[v]});
                }
            }
        }
        return dist[n - 1] <= k;
    }
}
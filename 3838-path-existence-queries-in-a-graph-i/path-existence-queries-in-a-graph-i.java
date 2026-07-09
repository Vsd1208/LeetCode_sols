class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // g[i] will store the connected component ID of node i
        int[] g = new int[n];
        int componentId = 0;
        
        // Traverse the array to assign component IDs
        // Since it's sorted, we only need to check adjacent elements
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                // Gap is too large; start a new component
                componentId++;
            }
            g[i] = componentId;
        }
        
        // Process the queries
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            
            // If they belong to the same component, they are connected
            result[i] = (g[u] == g[v]);
        }
        
        return result;
    }
}
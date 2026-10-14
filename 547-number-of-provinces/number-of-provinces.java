class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
            for (int j = 0; j < n; j++) {
                map.get(i).put(j, isConnected[i][j]);
            }
        }
        HashSet<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(map, visited, i);
                count++;
            }
        }
        return count;
    }
    private void dfs(Map<Integer, Map<Integer, Integer>> map,
                     HashSet<Integer> visited, int curr) {
        visited.add(curr);
        for (Map.Entry<Integer, Integer> entry : map.get(curr).entrySet()) {
            int next = entry.getKey();
            int val = entry.getValue();
            if (next != curr && val == 1 && !visited.contains(next)) {
                dfs(map, visited, next);
            }
        }
    }
}
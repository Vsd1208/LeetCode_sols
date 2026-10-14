class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];
            graph.computeIfAbsent(a, k -> new HashMap<>());
            graph.computeIfAbsent(b, k -> new HashMap<>());
            graph.get(a).put(b, value);
            graph.get(b).put(a, 1.0 / value);
        }
        for (String start : graph.keySet()) {
            Set<String> visited = new HashSet<>();
            dfs(start, start, 1.0, graph, visited);
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            if (!graph.containsKey(x) || !graph.containsKey(y)) {
                ans[i] = -1.0;
            } else if (graph.get(x).containsKey(y)) {
                ans[i] = graph.get(x).get(y);
            } else {
                ans[i] = -1.0;
            }
        }
        return ans;
    }
    private void dfs(String start, String curr, double product,
                 Map<String, Map<String, Double>> graph,
                 Set<String> visited) {

        visited.add(curr);
        graph.get(start).put(curr, product);

        for (Map.Entry<String, Double> entry :
            new HashMap<>(graph.get(curr)).entrySet()) {

            String next = entry.getKey();
            double value = entry.getValue();

            if (!visited.contains(next)) {
                dfs(start, next, product * value, graph, visited);
            }
        }
    }
}
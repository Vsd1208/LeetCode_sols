class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] p : prerequisites) {
            map.putIfAbsent(p[0], new HashSet<>());
            map.get(p[0]).add(p[1]);
        }
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, map, visited, new HashSet<>())) {
                return false;
            }
        }
        return true;
    }
    private boolean hasCycle(int course,HashMap<Integer, HashSet<Integer>> map,HashSet<Integer> visited,HashSet<Integer> path) {

        if (path.contains(course)) {
            return true;
        }

        if (visited.contains(course)) {
            return false;
        }

        if (!map.containsKey(course)) {
            visited.add(course);
            return false;
        }

        path.add(course);

        for (int pre : map.get(course)) {
            if (hasCycle(pre, map, visited, path)) {
                return true;
            }
        }

        path.remove(course);
        visited.add(course);

        return false;
    }
}
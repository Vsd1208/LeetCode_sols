class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean check = false;
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<wordDict.size();i++)
            set.add(wordDict.get(i));
        boolean[] visited = new boolean[s.length() + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int start = q.poll();
            if (visited[start])
            continue;
            visited[start] = true;
            for (int end = start + 1; end <= s.length(); end++) {
                if(set.contains(s.substring(start, end))) {
                    if(end == s.length())
                        return true;
                    q.offer(end);
                }
            }
        }
        return false;
    }
}
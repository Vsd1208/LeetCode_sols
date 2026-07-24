class Solution {
    private boolean oneDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                diff++;
        }
        return diff == 1;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        int level=1;
        q.add(beginWord);
        visited.add(beginWord);
        if (!wordList.contains(endWord))
            return 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                String word = q.poll();
                if(word.equals(endWord)) return level; 
                for(int i=0;i<wordList.size();i++){
                    String str = wordList.get(i);
                    if(oneDiff(word,str) && !visited.contains(str)){
                        q.add(str);
                        visited.add(str);
                    }
                }
                size-=1;
            }
            level++;
        }
        return 0;
    }
}
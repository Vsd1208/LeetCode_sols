class WordDictionary {
    private class TrieNode{
        TrieNode[] node;
        boolean end;
        private TrieNode(){
            node = new TrieNode[26];
            end=false;
        }
        private boolean contains(char ch){
            return node[ch-'a']!=null;
        }
        private void add(char ch,TrieNode n){
            node[ch-'a']=n;
        }
        private TrieNode get(char ch){
            if(contains(ch)) return node[ch-'a'];
            else return null;
        }
        private void end(){
            end=true;
        }
        private boolean isEnd(){
            return end;
        }
    }
    TrieNode node;
    public WordDictionary() {
        node = new TrieNode();
    }
    public void addWord(String word) {
        TrieNode curr = node;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!curr.contains(ch))
                curr.add(ch,new TrieNode());
            curr=curr.get(ch);
        }
        curr.end();
    }
    private boolean dfs(TrieNode curr,int index,String word){
        if(index==word.length()){
            return curr.isEnd();
        }
        char ch=word.charAt(index);
        if(ch=='.'){
            for(int i=0;i<26;i++){
                if(curr.node[i]!=null){
                    if(dfs(curr.node[i],index+1,word)){
                        return true;
                    }
                }
            }
            return false;
        }
        if(curr.get(ch)==null) return false;
        return dfs(curr.get(ch),index+1,word);
    }
    public boolean search(String word) {
        TrieNode curr = node;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ch=='.'){
                for(int j=0;j<26;j++){
                    if(curr.node[j]!=null){
                        if(dfs(curr.node[j],i+1,word)){
                            return true;
                        }
                    }
                }
                return false;
            }
            if(curr.contains(ch)){
                curr=curr.get(ch);
            }
            else return false;
        }
        return curr.isEnd();
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
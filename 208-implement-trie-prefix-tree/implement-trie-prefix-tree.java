class Trie {
    class TrieNode{
        private TrieNode[] child;
        private boolean end;
        private TrieNode(){
            child = new TrieNode[26];
            end = false;
        }
        private boolean containsKey(char ch){
            return child[ch-'a']!=null;
        }
        private TrieNode getNode(char ch){
            return child[ch-'a'];
        }
        public void putNode(char ch,TrieNode n){
            child[ch-'a']=n;
        }
        public void setEnd() {
            end = true;
        }
        private boolean isEnd() {
            return end;
        }
    }
    private final TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!curr.containsKey(ch))
                curr.putNode(ch,new TrieNode());
            curr=curr.getNode(ch);
        }
        curr.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.containsKey(ch)){
                curr=curr.getNode(ch);
            }
            else return false;
        }
        return curr.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!current.containsKey(ch)) {
                return false;
            }
            current = current.getNode(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
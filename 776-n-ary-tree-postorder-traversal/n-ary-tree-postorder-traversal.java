/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    private void dfs(Node root,List<Integer> pr){
        if(root==null) return;
        for(Node child : root.children){
            dfs(child,pr);
        }
        pr.add(root.val);
    }
    public List<Integer> postorder(Node root) {
        List<Integer> pr = new ArrayList<>();
        dfs(root,pr);
        return pr;
    }
}
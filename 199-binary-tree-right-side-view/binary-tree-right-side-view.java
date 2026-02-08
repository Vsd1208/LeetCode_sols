/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void adds(TreeNode root,int level,List<Integer> nodes){
        if(root==null) return;
        if(level==nodes.size())
            nodes.add(root.val);
        adds(root.right,level+1,nodes);
        adds(root.left,level+1,nodes);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        adds(root,0,nodes);
        return nodes;
    }
}
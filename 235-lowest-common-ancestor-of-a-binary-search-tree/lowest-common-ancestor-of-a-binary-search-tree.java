/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private TreeNode traversal(TreeNode root,TreeNode p,TreeNode q){
        if(root==null) return null;
        if(root.val>p.val && root.val>q.val)
            return traversal(root.left,p,q);
        if(root.val<p.val && root.val<q.val)
            return traversal(root.right,p,q);
        return root;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traversal(root,p,q);
    }
}
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
    private boolean finder(TreeNode root){
        if(root==null) return false;
        return (root.val==1 || finder(root.left) || finder(root.right));
    }
    public TreeNode pruneTree(TreeNode root) {
        if(root==null) return null;
        root.left=pruneTree(root.left);
        root.right=pruneTree(root.right);
        if(!finder(root)) root=null;
        return root;
    }
}
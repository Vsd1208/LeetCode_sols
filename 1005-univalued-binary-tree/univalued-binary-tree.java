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
    private boolean cond=true;
    private void check(TreeNode root,int num){
        if(root==null) return;
        check(root.left,num);
        check(root.right,num);
        cond = (cond && num==root.val);
    }
    public boolean isUnivalTree(TreeNode root) {
        int num=root.val;
        check(root,num);
        return cond;
    }
}
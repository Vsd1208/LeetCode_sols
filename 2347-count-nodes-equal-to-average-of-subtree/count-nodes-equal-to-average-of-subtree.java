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
    private int sum(TreeNode root){
        if(root==null) return 0;
        int s=root.val;
        s+=sum(root.left);
        s+=sum(root.right);
        return s;
    }
    private int size(TreeNode root){
        if(root==null) return 0;
        int l=1;
        l+=size(root.left);
        l+=size(root.right);
        return l;
    }
    int count=0;
    public int averageOfSubtree(TreeNode root) {
        if(root==null) return count;
        int s=sum(root);
        int l=size(root);
        if(s/l==root.val) count++;
        averageOfSubtree(root.left);
        averageOfSubtree(root.right);
        return count;
    }
}
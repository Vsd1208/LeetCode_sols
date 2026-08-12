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
    int index=0;
    private int max_depth(TreeNode root){
        if (root == null) return 0;
        return Math.max(max_depth(root.left),max_depth(root.right)) + 1;
    }
    private TreeNode get_Node(TreeNode root, int depth) {
        if (root == null)
            return null;
        if (depth == 1)
            return root;
        TreeNode left = get_Node(root.left, depth - 1);
        TreeNode right = get_Node(root.right, depth - 1);
        if (left != null && right != null)
            return root;
        if (left != null)
            return left;
        return right;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int depth = max_depth(root);
        return get_Node(root,depth);
    }
}
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
    private int sum = 0;
    private void sumRoot(TreeNode root, int s) {
        if (root == null) return;
        s = (s << 1) | root.val;
        if (root.left == null && root.right == null) {
            sum += s;
            return;
        }
        sumRoot(root.left, s);
        sumRoot(root.right, s);
    }
    public int sumRootToLeaf(TreeNode root) {
        sumRoot(root, 0);
        return sum;
    }
}
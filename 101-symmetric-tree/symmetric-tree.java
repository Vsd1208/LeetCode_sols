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
    private void leftPre(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
            return;
        }
        list.add(root.val);
        leftPre(root.left, list);
        leftPre(root.right, list);
    }
    private void rightPre(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
            return;
        }
        list.add(root.val);
        rightPre(root.right, list);
        rightPre(root.left, list);
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        leftPre(root.left, left);
        rightPre(root.right, right);
        return left.equals(right);
    }
}
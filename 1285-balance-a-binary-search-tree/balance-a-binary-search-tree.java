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
    private List<Integer> sorted;
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        sorted.add(root.val);
        inorder(root.right);
    }
    private TreeNode buildBST(int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(sorted.get(mid));
        root.left = buildBST(left, mid - 1);
        root.right = buildBST(mid + 1, right);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        sorted = new ArrayList<>();
        inorder(root);
        return buildBST(0, sorted.size() - 1);
    }
}
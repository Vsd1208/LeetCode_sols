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
    public boolean isEvenOddTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int level = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            int prev = (level % 2 == 0)
                    ? Integer.MIN_VALUE
                    : Integer.MAX_VALUE;

            while (size-- > 0) {

                TreeNode node = q.poll();

                if (level % 2 == 0) {

                    // Even level: values should be odd and strictly increasing
                    if (node.val % 2 == 0 || node.val <= prev)
                        return false;

                } else {

                    // Odd level: values should be even and strictly decreasing
                    if (node.val % 2 != 0 || node.val >= prev)
                        return false;

                }

                prev = node.val;

                if (node.left != null)
                    q.offer(node.left);

                if (node.right != null)
                    q.offer(node.right);
            }

            level++;
        }

        return true;
    }
}
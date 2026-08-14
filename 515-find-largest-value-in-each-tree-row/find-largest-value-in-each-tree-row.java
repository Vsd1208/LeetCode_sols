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
    private void bfs(TreeNode root, List<Integer> max_value) {
        if (root == null) return;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode r = q.poll();
                max = Math.max(max, r.val);
                if (r.left != null)
                    q.add(r.left);
                if (r.right != null)
                    q.add(r.right);
            }
            max_value.add(max);
        }
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> max_value = new ArrayList<>();
        bfs(root,max_value);
        return max_value;
    }
}
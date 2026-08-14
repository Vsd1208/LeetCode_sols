class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null) return root2;
        if (root2 == null) return root1;

        Queue<TreeNode[]> q = new ArrayDeque<>();
        q.add(new TreeNode[]{root1, root2});

        while (!q.isEmpty()) {

            TreeNode[] pair = q.poll();

            TreeNode a = pair[0];
            TreeNode b = pair[1];

            // Merge current nodes
            a.val += b.val;

            // Left side
            if (a.left == null) {
                a.left = b.left;
            } 
            else if (b.left != null) {
                q.add(new TreeNode[]{a.left, b.left});
            }

            // Right side
            if (a.right == null) {
                a.right = b.right;
            } 
            else if (b.right != null) {
                q.add(new TreeNode[]{a.right, b.right});
            }
        }

        return root1;
    }
}
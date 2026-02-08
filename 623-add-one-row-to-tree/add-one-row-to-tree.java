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
    private void adds(TreeNode root,int val,int depth){
        if (root == null) return;
        if(depth==1){
            TreeNode tl = new TreeNode(val);
            TreeNode tr = new TreeNode(val);
            tl.left=root.left;
            tr.right=root.right;
            root.left=tl;
            root.right=tr;
            return;
        }
        adds(root.left,val,depth-1);
        adds(root.right,val,depth-1);
        return;
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        depth-=1;
        if(depth==0){
            TreeNode t = new TreeNode(val);
            t.left=root;
            return t;
        };
        adds(root,val,depth);
        return root;
    }
}
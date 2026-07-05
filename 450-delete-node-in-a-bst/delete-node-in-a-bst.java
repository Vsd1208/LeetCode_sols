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
    private TreeNode constructBST(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        TreeNode node = root;
        if(node.val>key) node.left=deleteNode(node.left,key);
        else if(node.val<key) node.right=deleteNode(node.right,key);
        else{
            if(node.left==null) return node.right;
            else if(node.right==null) return node.left;
            TreeNode successor = constructBST(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }
}
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
    private void rev_inorder(TreeNode root, Stack<Integer> s){
        if(root == null) return;
        rev_inorder(root.right, s);
        s.push(root.val);
        rev_inorder(root.left, s);
    }
    public TreeNode increasingBST(TreeNode root) {
        Stack<Integer> s = new Stack<>();
        rev_inorder(root, s);
        TreeNode root1 = null;
        TreeNode curr = null;
        while(!s.isEmpty()){
            if(root1 == null){
                root1 = new TreeNode(s.pop());
                curr = root1;
            } 
            else{
                curr.right = new TreeNode(s.pop());  // FIXED
                curr = curr.right;
            }
        }
        return root1;
    }
}
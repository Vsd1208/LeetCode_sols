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
    private void inorder(TreeNode root,List<Integer> values){
        if(root==null) return;
        inorder(root.left,values);
        values.add(root.val);
        inorder(root.right,values);
    }
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<list.size()-1;i++){
            min = Math.min(min,list.get(i+1)-list.get(i));
        }
        return min;
    }
}
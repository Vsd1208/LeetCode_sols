/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private boolean dfs(TreeNode root,TreeNode p,List<TreeNode> list){
        if(root==null) return false;
        list.add(root);
        if(root==p) return true;
        if(dfs(root.left,p,list) || dfs(root.right,p,list)) return true;
        list.remove(list.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        dfs(root, p, list1);
        dfs(root, q, list2);
        int i = 0;
        TreeNode ans = null;
        while (i < list1.size() && i < list2.size()) {
            if (list1.get(i) != list2.get(i))
                break;
            ans = list1.get(i);
            i++;
        }
        return ans;
    }
}
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
    private HashMap<Integer, List<TreeNode>> map;
    private int subTreeSum(TreeNode root) {
        if(root == null) return 0;
        int sum = root.val;
        sum += subTreeSum(root.left);
        sum += subTreeSum(root.right);
        if(map.containsKey(sum)) {
            map.get(sum).add(root);
        }
        else {
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            map.put(sum, list);
        }
        return sum;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        subTreeSum(root);
        int max = 0;
        for(List<TreeNode> list : map.values()) {
            max = Math.max(max, list.size());
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        for(int sum : map.keySet()) {
            if(map.get(sum).size() == max) {
                resultList.add(sum);
            }
        }
        int[] result = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
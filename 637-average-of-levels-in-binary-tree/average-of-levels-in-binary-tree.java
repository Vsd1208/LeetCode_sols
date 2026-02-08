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
    private static class Node {
        double sum = 0;
        int count = 0;
    }
    private void average(TreeNode root, int level, List<Node> avg) {
        if (root == null) return;
        if (avg.size() == level) {
            avg.add(new Node());
        }
        avg.get(level).sum += root.val;
        avg.get(level).count++;
        average(root.left, level + 1, avg);
        average(root.right, level + 1, avg);
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Node> avg = new ArrayList<>();
        average(root, 0, avg);
        List<Double> result = new ArrayList<>();
        for (Node n : avg) {
            result.add(n.sum / n.count);
        }
        return result;
    }
}
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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        heightFromBottom(root, result);
        return result;
    }
    
    public int heightFromBottom(TreeNode node, List<List<Integer>> result) {
        if (node == null) {
            return -1;
        }
        int height = 1 + Math.max(heightFromBottom(node.left, result),
                                 heightFromBottom(node.right, result));
        if (height >= result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(height).add(node.val);
        return height;
    }
}

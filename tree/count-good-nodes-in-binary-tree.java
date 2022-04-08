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
    
    public int goodNodes(TreeNode root) {
        return traverse(root, Integer.MIN_VALUE);
    }
    
    public int traverse(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int good = 0;
        if (root.val >= max) {
            max = root.val;
            good = 1;
        }
        return good + traverse(root.left, max) + traverse(root.right, max);
    }
}

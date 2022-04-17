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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        if (left != null) {
            return left;
        }
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (right != null) {
            return right;
        }
        if (find(root, p) && find(root, q)) {
            return root;
        }
        return null;
    }
    
    public boolean find(TreeNode node, TreeNode target) {
        if (node == null) {
            return false;
        }
        if (node == target) {
            return true;
        }
        return find(node.left, target) || find(node.right, target);
    }
}

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
    public int findSecondMinimumValue(TreeNode root) {
        return recurse(root, root.val);
    }
    
    public int recurse(TreeNode root, int min) {
        if (root == null) {
            return -1;
        }
        
        if (root.val > min) {
            return root.val;
        }
        
        int left = recurse(root.left, min);
        int right = recurse(root.right, min);
        
        if (left != -1 && right != -1) {
            return Math.min(left, right);
        }
        if (left != -1 && right == -1) {
            return left;
        }
        if (left == -1 && right != -1) {
            return right;
        }
        return -1;
    }
}

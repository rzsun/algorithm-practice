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
    public int rob(TreeNode root) {
        int[] result = recurse(root);
        return Math.max(result[0], result[1]);
    }
    
    // [include, exclude]
    public int[] recurse(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        
        int[] left = recurse(root.left);
        int[] right = recurse(root.right);
        
        // max include is root with max excluded of children
        int maxInclude = root.val + left[1] + right[1];
        
        // max exclude is sum of max include/exclude of children
        int maxExclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return new int[] {maxInclude, maxExclude};
    }
}

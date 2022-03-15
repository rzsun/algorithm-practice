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
    public boolean isValidBST(TreeNode root) {
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        Integer prev = null;
        
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.addFirst(root);
                root = root.left;
            }

            root = stack.pollFirst();
            if (root != null) {
                if (prev == null) {
                    prev = root.val;
                } else {
                    if (prev >= root.val) {
                        return false;
                    }
                    prev = root.val;
                }
            }
            root = root.right;
        }
        return true;
        
    }
}

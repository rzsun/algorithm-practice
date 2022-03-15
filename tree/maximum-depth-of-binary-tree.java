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
    public int maxDepth(TreeNode root) {
        
        Deque<TreeNode> curLevel = new ArrayDeque<>();
        if (root != null) {
            curLevel.addFirst(root);
        }
        int level = 0;
        
        while (!curLevel.isEmpty()) {
            
            Deque<TreeNode> nextLevel = new ArrayDeque<>();
            while(!curLevel.isEmpty()) {
                TreeNode cur = curLevel.pollFirst();                
                if (cur.left != null) {
                    nextLevel.addFirst(cur.left);
                }
                
                if (cur.right != null) {
                    nextLevel.addFirst(cur.right);
                }
            }
            
            curLevel = nextLevel;
            level++;
        }
        
        return level;
    }
}

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
    public int widthOfBinaryTree(TreeNode root) {
        return calculateMins(root, 0, 1L, new ArrayList<>()).intValue();
    }
    
    public Long calculateMins(TreeNode root, int level, long pos, List<Long> levelMin) {
        if (root == null) {
            return 0L;
        }
        if (levelMin.size() <= level) {
            levelMin.add(pos);
        } else {
            levelMin.set(level, Math.min(pos, levelMin.get(level)));
        }
        Long distance = pos - levelMin.get(level) + 1;
        Long max = Math.max(
            calculateMins(root.left, level + 1, 2 * pos, levelMin), 
            calculateMins(root.right, level + 1, 2 * pos + 1, levelMin));
        return Math.max(max, distance);
    }
}

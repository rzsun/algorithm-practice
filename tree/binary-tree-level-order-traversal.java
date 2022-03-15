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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> results = new ArrayList<>();

        List<TreeNode> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        
        while (true) {
            
            List<TreeNode> nextLevel = new ArrayList<>();
            List<Integer> vals = new ArrayList<>();
            
            for (TreeNode n : currentLevel) {
                vals.add(n.val);
                if (n.left != null) {
                    nextLevel.add(n.left);
                }
                if (n.right != null) {
                    nextLevel.add(n.right);
                }
            }
            results.add(vals);
            
            if (nextLevel.size() == 0) {
                return results;
            }
            
            currentLevel = nextLevel;
        }
       
    }
}

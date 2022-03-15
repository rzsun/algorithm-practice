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
    public int maxPathSum(TreeNode root) {
        
        Map<Integer, List<TreeNode>> levels = new HashMap<>();
        
        if (root != null) {
            levels.put(0, new ArrayList<>());
            levels.get(0).add(root);
        }
        
        int level = 0;
        while (true) {
            List<TreeNode> curLevel = levels.get(level);
            List<TreeNode> nextLevel = new ArrayList<>();
            
            for (TreeNode node : curLevel) {
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            
            if (nextLevel.size() == 0) {
                break;
            }
            level++;
            levels.put(level, nextLevel);
        }
        
        Map<TreeNode, Integer> maxLeg = new HashMap<>();
        
        for (int i = levels.keySet().size() - 1; i >= 0; i--) {
            for (TreeNode node : levels.get(i)) {
                int left;
                if (node.left == null) {
                    left = 0;
                } else {
                    left = maxLeg.get(node.left);
                }
                
                int right;
                if (node.right == null) {
                    right = 0;
                } else {
                    right = maxLeg.get(node.right);
                }
                int value = Math.max(node.val, Math.max(left + node.val, right + node.val));
                maxLeg.put(node, value);
            }
        }
        
        int max = root.val;
        for (Map.Entry<TreeNode, Integer> entry : maxLeg.entrySet()) {
            TreeNode node = entry.getKey();
            int value = node.val;
            if (value > max) {
                max = value;
            }
            int leftVal = 0;
            if (node.left != null) {
                leftVal = maxLeg.get(node.left);
            }
            int rightVal = 0;
            if (node.right != null) {
                rightVal = maxLeg.get(node.right);
            }
            max = Math.max(max, value + leftVal);
            max = Math.max(max, value + rightVal);
            max = Math.max(max, value + leftVal + rightVal);
        }
        return max;
    }
}

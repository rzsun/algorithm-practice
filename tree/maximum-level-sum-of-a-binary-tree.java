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
    public int maxLevelSum(TreeNode root) {
        
        Deque<TreeNode> curLevel = new ArrayDeque<>();
        
        List<Integer> levelSums = new ArrayList<>();
        
        curLevel.addFirst(root);
        
        while (!curLevel.isEmpty()) {
            int sum = 0;
            
            Deque<TreeNode> nextLevel = new ArrayDeque<>();
            while(!curLevel.isEmpty()) {
                TreeNode cur = curLevel.pollFirst();
                sum += cur.val;
                
                if (cur.left != null) {
                    nextLevel.addFirst(cur.left);
                }
                
                if (cur.right != null) {
                    nextLevel.addFirst(cur.right);
                }
            }
            
            curLevel = nextLevel;
            levelSums.add(sum);
        }
        
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        
        for (int i = 0; i < levelSums.size(); i++) {
            if (levelSums.get(i) > maxSum) {
                maxSum  = levelSums.get(i);
                maxLevel = i + 1;
            }
        }
        return maxLevel;
        
    }
}

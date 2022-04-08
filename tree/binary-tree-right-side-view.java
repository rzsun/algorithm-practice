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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Deque<TreeNode> curLevel = new ArrayDeque<>();
        Deque<TreeNode> nextLevel = new ArrayDeque<>();
        curLevel.push(root);
        
        while (!curLevel.isEmpty()) {
            result.add(curLevel.peekLast().val);
            TreeNode cur = curLevel.pollFirst();
            while(cur != null) {
                if (cur.left != null) {
                    nextLevel.addLast(cur.left);
                }
                if (cur.right != null) {
                    nextLevel.addLast(cur.right);
                }
                cur = curLevel.pollFirst();
            }
            
            curLevel = nextLevel;
            nextLevel = new ArrayDeque<>();
        }
        return result;
    }
}

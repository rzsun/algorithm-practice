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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        
        Deque<Integer> deque = new ArrayDeque<>();
        inorder(root, deque);
        while (deque.size() > k) {
            if (Math.abs(deque.peekFirst() - target) > 
                Math.abs(deque.peekLast() - target)) {
                deque.removeFirst();
            } else {
                deque.removeLast();
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        result.addAll(deque);
        return result;
    }
    
    public void inorder(TreeNode root, Deque<Integer> deque) {
        if (root == null) {
            return;
        }
        inorder(root.left, deque);
        deque.addLast(root.val);
        inorder(root.right, deque);
    }
}

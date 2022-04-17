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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        
        TreeNode lca = lowestCommonAncestor(root, startValue, destValue);
        
        StringBuilder result = new StringBuilder();
        Deque<String> pathToStart = new ArrayDeque<>();
        pathToTarget(lca, startValue, pathToStart);
        for (int i = 0; i < pathToStart.size(); i++) {
            result.append("U");
        }
        Deque<String> pathToEnd = new ArrayDeque<>();
        pathToTarget(lca, destValue, pathToEnd);
        while (!pathToEnd.isEmpty()) {
            result.append(pathToEnd.pollFirst());
        }
        return result.toString();
    }
    
    public boolean pathToTarget(TreeNode root, int target, Deque<String> result) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        result.addLast("L");
        if (pathToTarget(root.left, target, result)) {
            return true;
        }
        result.removeLast();
        result.addLast("R");
        if (pathToTarget(root.right, target, result)) {
            return true;
        }
        result.removeLast();
        return false;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, int startValue, int destValue) {
        if (root == null) {
            return null;
        }
        if (root.val == startValue) {
            return root;
        }
        if (root.val == destValue) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, startValue, destValue);
        TreeNode right = lowestCommonAncestor(root.right, startValue, destValue);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }

}

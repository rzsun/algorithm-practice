/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    class Found {
        TreeNode lca = null;
        boolean foundP = false;
        boolean foundQ = false;
        
        public Found(TreeNode lca, boolean foundP, boolean foundQ) {
            this.lca = lca;
            this.foundP = foundP;
            this.foundQ = foundQ;
        }
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Found f = lowestCommonAncestorFind(root, p, q);
        if (f.lca != null) {
            return f.lca;
        }
        return null;
    }
    
    public Found lowestCommonAncestorFind(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Found(null, false, false);
        }
        boolean foundP = (root == p);
        boolean foundQ = (root == q);
        
        Found left = lowestCommonAncestorFind(root.left, p, q);
        Found right = lowestCommonAncestorFind(root.right, p, q);
        if (left.lca != null) {
            return left;
        }
        if (right.lca != null) {
            return right;
        }
        
        foundP = foundP || left.foundP || right.foundP;
        foundQ = foundQ || left.foundQ || right.foundQ;
        if (foundP && foundQ) {
            return new Found(root, true, true);
        }
        
        return new Found(null, foundP, foundQ);
    }
}

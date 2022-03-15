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
    
    // recursive
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        
        if (p == null && q != null) {
            return false;
        }
        
        if (p != null && q == null) {
            return false;
        }
        
        if (p.val != q.val) {
            return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
    // iterative
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        
        if (p == null && q == null) {
            return true;
        }
        
        if (p == null || q == null) {
            return false;
        }
        stack.addLast(p);
        stack.addLast(q);
        
        while (!stack.isEmpty()) {
            p = stack.removeFirst();
            q = stack.removeFirst();
            
            if (p.val != q.val) {
                return false;
            }
            
            if (p.left != null && q.left != null) {
                stack.addLast(p.left);
                stack.addLast(q.left);
            }
            
            if (p.left == null && q.left != null) {
                return false;
            }
            
            if (p.left != null && q.left == null) {
                return false;
            }
            
            if (p.right != null && q.right != null) {
                stack.addLast(p.right);
                stack.addLast(q.right);
            }
            
            if (p.right == null && q.right != null) {
                return false;
            }
            
            if (p.right != null && q.right == null) {
                return false;
            }
            
        }
        return true;
    }
}

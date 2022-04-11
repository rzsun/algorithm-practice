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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeTraversal(preorder, inorder, 
                                  0, preorder.length,
                                  0, inorder.length);
    }
    
    public TreeNode buildTreeTraversal(int[] preorder, int[] inorder,
                                      int plow, int phigh,
                                      int ilow, int ihigh) {
        if (plow >= phigh || ilow >= ihigh) {
            return null;
        }
        int rootVal = preorder[plow];
        TreeNode root = new TreeNode(rootVal);
        int mid = -1;
        for (int i = ilow; i < ihigh; i++) {
            if (inorder[i] == rootVal) {
                mid = i;
                break;
            }
        }
        int leftSize = mid - ilow;
        root.left = buildTreeTraversal(preorder, inorder,
                                      plow + 1, plow + 1 + leftSize,
                                      ilow, mid);
        root.right = buildTreeTraversal(preorder, inorder,
                                       plow + 1 + leftSize, phigh,
                                       mid + 1, ihigh);
        return root;
    }
}

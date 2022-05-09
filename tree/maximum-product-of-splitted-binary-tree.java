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
    public int maxProduct(TreeNode root) {
        Map<TreeNode, Long> sums = new HashMap<>();
        calculateSums(sums, root);
        long total = sums.get(root);
        long max = 0;
        for (Map.Entry<TreeNode, Long> entry : sums.entrySet()) {
            TreeNode node = entry.getKey();
            Long val =  entry.getValue();
            
            if (node.left != null) {
                Long subTreeVal = sums.get(node.left);
                max = Math.max((total - subTreeVal) * subTreeVal, max);
            }
            if (node.right != null) {
                Long subTreeVal = sums.get(node.right);
                max = Math.max((total - subTreeVal) * subTreeVal, max);
            }
        }
        return (int)(max % (int)(Math.pow(10, 9) + 7));
    }
    
    public int calculateSums(Map<TreeNode, Long> sums, TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = calculateSums(sums, root.left);
        int right = calculateSums(sums, root.right);
        int sum = root.val + left + right;
        sums.put(root, new Long(sum));
        return sum;
    }
}

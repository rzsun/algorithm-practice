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
    
    public class TreeNodeColumn {
        TreeNode node;
        int column;
        TreeNodeColumn(TreeNode node, int column) {
            this.node = node;
            this.column = column;
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result; 
        }
        
        Map<Integer, List<Integer>> columns = new HashMap<>();
        int min = 0;
        int max = 0;
        
        Deque<TreeNodeColumn> queue = new ArrayDeque<>();
        queue.addFirst(new TreeNodeColumn(root, 0));
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNodeColumn treeNodeColumn = queue.pollFirst();
                TreeNode node = treeNodeColumn.node;
                int column = treeNodeColumn.column;
                
                min = Math.min(column, min);
                max = Math.max(column, max);
                
                if (!columns.containsKey(column)) {
                    columns.put(column, new ArrayList<>());
                }
                columns.get(column).add(node.val);
                
                if (node.left != null) {
                    queue.addLast(new TreeNodeColumn(node.left, column - 1));
                }
                
                if (node.right != null) {
                    queue.addLast(new TreeNodeColumn(node.right, column + 1));
                }
            }
        }
        
        for (int i = min; i <= max; i++) {
            result.add(columns.get(i));
        }
        
        return result;
    }
    
}

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
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap();
        traverse(root, map, 0, 0);
        
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, List<Integer>> col : map.values()) {
            List<Integer> vals = new ArrayList<>();
            for (List<Integer> l : col.values()) {
                Collections.sort(l);
                vals.addAll(l);
            }
            result.add(vals);
        }
        
        return result;
    }
    
    public void traverse(TreeNode root,
                         TreeMap<Integer, TreeMap<Integer, List<Integer>>> result,
                         int column,
                         int depth) {
        if (root == null) {
            return;
        }
        if (!result.containsKey(column)) {
            result.put(column, new TreeMap<>());
        }
        Map<Integer, List<Integer>> ls = result.get(column);
        
        if (!ls.containsKey(depth)) {
            ls.put(depth, new ArrayList<>());
        }
        ls.get(depth).add(root.val);
        
        traverse(root.left, result, column - 1, depth + 1);
        traverse(root.right, result, column + 1, depth + 1);
    }
}

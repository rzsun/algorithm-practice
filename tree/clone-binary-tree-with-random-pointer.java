/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        Map<Node, NodeCopy> m = new HashMap<>();
        clone(root, m);
        copyPointer(root, m);
        return m.get(root);
    }
    
    public void clone(Node r, Map<Node, NodeCopy> m) {
        if (r == null) {
            return;
        }
        m.put(r, new NodeCopy(r.val));
        clone(r.left, m);
        clone(r.right, m);
    }
    
    public void copyPointer(Node r, Map<Node, NodeCopy> m) {
        if (r == null) {
            return;
        }
        NodeCopy n = m.get(r);
        n.left = m.get(r.left);
        n.right = m.get(r.right);
        n.random = m.get(r.random);
        copyPointer(r.left, m);
        copyPointer(r.right, m);
    }
}

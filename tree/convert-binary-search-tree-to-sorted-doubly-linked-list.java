/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    
    
    public Node treeToDoublyList(Node root) {
        List<Node> l = new ArrayList<>();
        inorder(root, l);
        if (l.size() == 0) {
            return null;
        }
        
        Node first = l.get(0);
        Node last = l.get(l.size() - 1);
        Node prev = last;
        for (int i = 0; i < l.size() - 1; i++) {
            Node n = l.get(i);
            n.left = prev;
            n.right = l.get(i+1);
            prev = n;
        }
        last.left = prev;
        last.right = first;
        return first;
    }
    
    public void inorder(Node root, List<Node> l) {
        if (root == null) {
            return;
        }
        inorder(root.left, l);
        l.add(root);
        inorder(root.right, l);
    }
}

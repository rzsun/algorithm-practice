/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node cloneTree(Node r) {
        if (r == null) {
            return null;
        }
        ArrayList<Node> children = new ArrayList<>();
        for (Node n : r.children) {
            children.add(cloneTree(n));
        }
        Node n = new Node(r.val, children);
        return n;
    }
}

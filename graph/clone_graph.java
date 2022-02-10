/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
        if (node == null) {
            return null;
        }
        
        Map<Node, Node> oldToNew = new HashMap<>();
        Node head = new Node(node.val);
        Deque<Node> stack = new ArrayDeque<>();
        oldToNew.put(node, head);
        
        for (Node n : node.neighbors) {
            Node newNode = new Node(n.val);
            oldToNew.put(n, newNode);
            stack.addFirst(n);
        }
        
        while(!stack.isEmpty()) {
            Node cur = stack.pollFirst();
            for (Node n : cur.neighbors) {
                if (!oldToNew.containsKey(n)) {
                    Node newNode = new Node(n.val);
                    oldToNew.put(n, newNode);
                    stack.addFirst(n);
                }
            }
        }
        
        populateNeighbors(oldToNew);
        return head;
    }
    
    private void populateNeighbors(Map<Node, Node> oldToNew) {
        for (Map.Entry<Node, Node> entry : oldToNew.entrySet()) {
            List<Node> newNeighbors = new ArrayList<>();
            for (Node n : entry.getKey().neighbors) {
                newNeighbors.add(oldToNew.get(n));
                
            }
            entry.getValue().neighbors = newNeighbors;
        }
    }
}

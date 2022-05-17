/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> m = new HashMap<>();
        
        Node cur = head;
        while (cur != null) {
            m.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        
        for (Map.Entry<Node, Node> e : m.entrySet()) {
            Node original = e.getKey();
            Node copy = e.getValue();
            if (original.next != null) {
                copy.next = m.get(original.next);
            }
            if (original.random != null) {
                copy.random = m.get(original.random);
            }
        }
        return m.get(head);
    }
}

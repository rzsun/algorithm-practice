class MaxStack {
    
    static class Node {
        int val;
        Node prev = null;
        Node next = null;
        Node(int val) {
            this.val = val;
        }
    }
    
    TreeMap<Integer, List<Node>> vals;
    Node head = null;

    public MaxStack() {
        vals = new TreeMap<>();
    }
    
    public void push(int x) {
        Node n = new Node(x);
        if (head != null) {
            head.next = n;
            n.prev = head;
        }
        head = n;
        if (!vals.containsKey(x)) {
            vals.put(x, new ArrayList<>());
        }
        vals.get(x).add(n);
    }
    
    public int pop() {
        int val = head.val;
        removeNode(head);
        return val;
    }
    
    public int top() {
        return head.val;
    }
    
    public int peekMax() {
        return vals.lastKey();
    }
    
    public int popMax() {
        List<Node> list = vals.lastEntry().getValue();
        Node n = list.get(list.size() - 1);
        removeNode(n);
        return n.val;
    }
    
    // should always be called with top most node of val
    private void removeNode(Node n) {
        List<Node> list = vals.get(n.val);
        list.remove(list.size() - 1);
        if (list.size() == 0) {
            vals.remove(n.val);
        }
        if (n.prev != null) {
            n.prev.next = n.next;
        }
        if (n.next != null) {
            n.next.prev = n.prev;
        }
        if (n == head) {
            head = head.prev;
        }
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */

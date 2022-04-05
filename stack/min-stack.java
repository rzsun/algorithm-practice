class MinStack {
    
    class Node {
        private Node next;
        private int val;
        private int min;
        public Node(Node next, int val, int min) {
            this.next = next;
            this.val = val;
            this.min = min;
        }
    }
    
    private Node head;

    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        int min;
        if (head == null) {
            min = val;
        } else {
            min = Math.min(head.min, val);
        }
        head = new Node(head, val, min);
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

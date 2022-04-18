class LRUCache {
    
    class Node {
        int val;
        int key;
        Node next = null;
        Node prev = null;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    private Node head;
    private Node tail;
    int maxCapacity;
    Map<Integer, Node> keys;

    public LRUCache(int capacity) {
        this.head = null;
        this.tail = null;
        this.maxCapacity = capacity;
        this.keys = new HashMap<>();
    }
    
    public int get(int key) {
        Node n = keys.get(key);
        if (n == null) {
            return -1;
        }
        removeNode(n);
        addNode(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        Node n = new Node(key, value);
        if (keys.containsKey(key)) {
            removeNode(keys.get(key));
        }
        keys.put(key, n);
        addNode(n);
        
        if (keys.size() > maxCapacity) {
            keys.remove(tail.key);
            removeNode(tail);
        }
    }
    
    
    private void removeNode(Node n) {
        Node next = n.next;
        Node prev = n.prev;
        if (next != null) {
            next.prev = prev;
        }
        if (prev != null) {
            prev.next = next;
        }
        if (n == tail) {
            tail = next;
        }
        if (n == head) {
            head = prev;
        }
    }
    
    private void addNode(Node n) {
        if (head != null) {
            head.next = n;
            n.prev = head;
            n.next = null;
        }
        if (tail == null) {
            tail = n;
        }
        head = n;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

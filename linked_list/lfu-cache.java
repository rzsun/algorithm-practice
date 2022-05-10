class LFUCache {
    class Node {
        int key;
        int value;
        int freq;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    int capacity;
    int size = 0;
    int min = 0;

    Map<Integer, LinkedHashSet<Node>> freq;
    Map<Integer, Node> cache;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.freq = new HashMap<>();
        this.cache = new HashMap<>();
    }

    public int get(int key) {
        Node n = cache.get(key);
        if (n == null) {
            return -1;
        }
        updateFreq(n);
        return n.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (cache.containsKey(key)) {
            Node n = cache.get(key);
            n.value = value;
            updateFreq(n);
        } else {
            if (size == capacity) {
                LinkedHashSet<Node> list = freq.get(min);
                Node evict = list.iterator().next();
                list.remove(evict);
                cache.remove(evict.key);
            } else {
                size++;
            }
            Node n = new Node(key, value);
            if (!freq.containsKey(1)) {
                freq.put(1, new LinkedHashSet<>());
            }
            freq.get(1).add(n);
            cache.put(key, n);
            min = 1;
        }
    }

    public void updateFreq(Node n) {
        LinkedHashSet<Node> list = freq.get(n.freq);
        list.remove(n);
        if (n.freq == min && list.size() == 0) {
            min++;
            freq.remove(n.freq);
        }
        n.freq += 1;
        if (!freq.containsKey(n.freq)) {
            freq.put(n.freq, new LinkedHashSet<>());
        }
        freq.get(n.freq).add(n);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class Trie {
    
    class Node {
        char c;
        boolean isEnd;
        Map<Character, Node> nexts;
        
        Node(char c) {
            this.c = c;
            this.isEnd = false;
            this.nexts = new HashMap<>();
        }
    }
    
    Map<Character, Node> starts;

    public Trie() {
        starts = new HashMap<>();
    }
    
    public void insert(String word) {
        char first = word.charAt(0);
        if (!starts.containsKey(first)) {
            starts.put(first, new Node(first));
        }
        Node parent = starts.get(first);
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            Node n;
            if (parent.nexts.containsKey(c)) {
                n = parent.nexts.get(c);
            } else {
                n = new Node(c);
                parent.nexts.put(c, n);
            }
            parent = n;
        }
        parent.isEnd = true;
    }
    
    public boolean search(String word) {
        char first = word.charAt(0);
        if (!starts.containsKey(first)) {
            return false;
        }
        Node parent = starts.get(first);
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if (parent.nexts.containsKey(c)) {
                parent = parent.nexts.get(c);
            } else {
                return false;
            }
        }
        return parent.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        char first = prefix.charAt(0);
        if (!starts.containsKey(first)) {
            return false;
        }
        Node parent = starts.get(first);
        for (int i = 1; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (parent.nexts.containsKey(c)) {
                parent = parent.nexts.get(c);
            } else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

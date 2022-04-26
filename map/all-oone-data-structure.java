/*
 NOTE: not optimal. use linked list instead to track max/min
*/

class AllOne {
    
    Map<String, Integer> strings;
    TreeMap<Integer, Set<String>> counts;

    public AllOne() {
        counts = new TreeMap<>();
        strings = new HashMap<>();
    }
    
    public void inc(String key) {
        int count = strings.getOrDefault(key, 0) + 1;
        strings.put(key, count);
        addCount(count, key);
        removeCount(count - 1, key);
    }
    
    public void dec(String key) {
        int count = strings.get(key);
        removeCount(count, key);
        if (count - 1 == 0) {
            strings.remove(key);
            return;
        }
        addCount(count - 1, key);
        strings.put(key, count - 1);
    }
    
    public String getMaxKey() {
        if (counts.size() == 0) {
            return "";
        }
        return counts.lastEntry().getValue().iterator().next();
    }
    
    public String getMinKey() {
        if (counts.size() == 0) {
            return "";
        }
        return counts.firstEntry().getValue().iterator().next();
    }
    
    private void addCount(int count, String s) {
        if (!counts.containsKey(count)) {
            counts.put(count, new HashSet<>());
        }
        counts.get(count).add(s);
    }
    
    private void removeCount(int count, String s) {
        Set<String> set = counts.get(count);
        if (set == null) {
            return;
        }
        set.remove(s);
        if (set.size() == 0) {
            counts.remove(count);
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */

class Solution {

    private Map<Integer, Integer> map;
    private int n;
    private int offset;
    
    public Solution(int n, int[] blacklist) {
        this.map = new HashMap<>();
        this.n = n;
        this.offset = blacklist.length;
        
        Set<Integer> vals = new HashSet<>();
        for (int i : blacklist) {
            vals.add(i);
        }
        
        int candidate = n;
        for (int i = 0; i < offset; i++) {
            if (blacklist[i] < n - offset) {
                candidate--;
                while (vals.contains(candidate)) {
                    candidate--;
                }
                map.put(blacklist[i], candidate);
            }
        }
    }
    
    public int pick() {
        int r = new Random().nextInt(n - offset);
        if (map.containsKey(r)) {
            return map.get(r);
        }
        return r;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */

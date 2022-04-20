class Solution {
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) {
            return false;
        }
        
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        
        int odd = 0;
        for (int count : counts.values()) {
            if (count % 2 == 1) {
                odd++;
            }
        }
        return odd <= k;
    }
}

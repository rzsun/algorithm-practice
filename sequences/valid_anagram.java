class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> counts = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            counts.put(cur, counts.getOrDefault(cur, 0) + 1);
        }
        
        for (int i = 0; i < t.length(); i++) {
            Character cur = t.charAt(i);
            if (!counts.containsKey(cur)) {
                return false;
            }
            counts.put(cur, counts.get(cur) - 1);
        }
        
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}

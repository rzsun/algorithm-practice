class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> times = new HashMap<>();
        
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            times.put(c, times.getOrDefault(c, 0) - 1);
        }
        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            times.put(c, times.getOrDefault(c, 0) + 1);
            if (times.get(c) == 0) {
                times.remove(c);
            }
        }
        if (times.keySet().size() == 0) {
            return true;
        }
        
        for (int i = s1.length(); i < s2.length(); i++) {
            char remove = s2.charAt(i - s1.length());
            times.put(remove, times.getOrDefault(remove, 0) - 1);
            if (times.get(remove) == 0) {
                times.remove(remove);
            }
            
            char add = s2.charAt(i);
            times.put(add, times.getOrDefault(add, 0) + 1);
            if (times.get(add) == 0) {
                times.remove(add);
            }
            if (times.keySet().size() == 0) {
                return true;
            }
        }
        return false;
    }
}

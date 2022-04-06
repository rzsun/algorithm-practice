class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            chars.put(t.charAt(i), chars.getOrDefault(t.charAt(i), 0) - 1);
        }
        
        int count = chars.keySet().size();

        Integer min = null;
        int subStart = 0;
        
        int low = 0;
        int high = 0;

        while (high < s.length()) {
            char c = s.charAt(high++);
            if (!chars.containsKey(c)) {
                continue;
            }
            chars.put(c, chars.get(c) + 1);
            if (chars.get(c) == 0) {
                count--;
            }
            
            while (count == 0) {
                if (min == null || high - low < min) {
                    subStart = low;
                    min = high - low;
                }

                c = s.charAt(low++);
                if (!chars.containsKey(c)) {
                    continue;
                }
                chars.put(c, chars.get(c) - 1);
                if (chars.get(c) < 0) {
                    count++;
                }
            }
            
        }
        if (min == null) {
            return "";
        }
        return s.substring(subStart, subStart + min);
    }
}

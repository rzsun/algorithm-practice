class Solution {
    public int characterReplacement(String s, int k) {
        
        Map<Character, Integer> times = new HashMap<>();
        
        int high = 0;
        int low = 0;
        int mostTimes = 0;
        int result = 0;
        
        while (high < s.length()) {
            char lowChar = s.charAt(low);
            char highChar = s.charAt(high);
            
            int curTimes = times.getOrDefault(s.charAt(high), 0) + 1;
            times.put(highChar, curTimes);
            
            mostTimes = Math.max(mostTimes, curTimes);
            
            while ((high - low + 1 - mostTimes) > k) {
                low++;
                times.put(lowChar, times.getOrDefault(lowChar, 1) - 1);
            }
            
            result = Math.max(result, high - low + 1);
            high++;
        }
        return result;
    }
}

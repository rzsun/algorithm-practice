class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int high = 0;
        int low = 0;
        
        Set<Character> seen = new HashSet<>();
        int max = 0;
        
        while (high < s.length()) {
            
            while (seen.contains(s.charAt(high))) {
                seen.remove(s.charAt(low));
                low++;
            }
            seen.add(s.charAt(high));
            max = Math.max(max, high - low + 1);
            high++;
        }
        return max;
    }
}

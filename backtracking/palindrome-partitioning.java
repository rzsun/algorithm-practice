class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        recurse(s, 0, new ArrayList<>(), results);
        return results;
    }
    
    public void recurse(String s, int start, 
                          List<String> partitions,
                          List<List<String>> results) {
        
        if (start == s.length()) {
            results.add(new ArrayList<>(partitions));
        }
        
        for (int i = start + 1; i <= s.length(); i++) {
            String part = s.substring(start, i);
            if (!isPalindrome(part)) {
                continue;
            }
            partitions.add(part);
            recurse(s, i, partitions, results);
            partitions.remove(partitions.size() - 1);
        }
    }
    
    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> anagrams = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            
            char[] sorted = strs[i].toCharArray();
            Arrays.sort(sorted);
            String sortedString = new String(sorted);
            
            if (!anagrams.containsKey(sortedString)) {
                anagrams.put(sortedString, new ArrayList<String>());
            }
            
            anagrams.get(sortedString).add(strs[i]);
        }
        
        
        return new ArrayList<List<String>>(anagrams.values());
    }
}

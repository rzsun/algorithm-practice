class Solution {
    public int longestStrChain(String[] words) {
        Set<String> wordsSet = new HashSet<>();
        for (String word : words) {
            wordsSet.add(word);
        }
        Map<String, Integer> cache = new HashMap<>();
        int maxPath = 0;
        for (String word : wordsSet) {
            maxPath = Math.max(maxPath, dfs(word, wordsSet, cache));
        }
        return maxPath;
    }
    
    public int dfs(String word, 
                   Set<String> wordsSet, 
                   Map<String, Integer> cache) {
        if (cache.containsKey(word)) {
            return cache.get(word);
        }
        int path = 1;
        for (int i = 0; i < word.length(); i++) {
            String newWord = word.substring(0, i) + word.substring(i+1, word.length());
            if (wordsSet.contains(newWord)) {
                path = Math.max(1 + dfs(newWord, wordsSet, cache), path);
            }
        }
        cache.put(word, path);
        return path;
    }
}

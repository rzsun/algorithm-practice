class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Map<String, Set<String>> wildcards = new HashMap<>();
        wordList.add(beginWord);
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String wildcard = word.substring(0, i) + "*" + 
                    word.substring(i + 1, word.length());
                if (!wildcards.containsKey(wildcard)) {
                    wildcards.put(wildcard, new HashSet<>());
                }
                wildcards.get(wildcard).add(word);
            }
        }
        
        Map<String, Set<String>> adjList = new HashMap<>(); // adjacency list
        for (Set<String> adjWords : wildcards.values()) {
            for (String word : adjWords) {
                if (!adjList.containsKey(word)) {
                    adjList.put(word, new HashSet<>());
                }
                adjList.get(word).addAll(adjWords);
                adjList.get(word).remove(word);
            }
        }
        
        int distance = 1;
        Set<String> explored = new HashSet<>();
        Deque<String> level = new ArrayDeque<>();
        level.addFirst(beginWord);
        Deque<String> nextLevel = new ArrayDeque<>();

        while (!level.isEmpty() || !nextLevel.isEmpty()) {
            String cur = level.poll();
            if (cur.equals(endWord)) {
                return distance;
            }
            explored.add(cur);
            if (!adjList.containsKey(cur)) {
                continue;
            }
            for (String word : adjList.get(cur)) {
                if (!explored.contains(word)) {
                    nextLevel.add(word);
                }
            }
            if (level.isEmpty()) {
                level = nextLevel;
                nextLevel = new ArrayDeque<>();
                distance++;
            }
        }
        return 0;
    }
}

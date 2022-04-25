class WordDistance {

    Map<String, List<Integer>> indices;
    
    public WordDistance(String[] wordsDict) {
        indices = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if (!indices.containsKey(word)) {
                indices.put(word, new ArrayList<>());
            }
            indices.get(word).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> indices1 = indices.get(word1);
        List<Integer> indices2 = indices.get(word2);
        
        int i = 0;
        int j = 0;
        int shortest = Integer.MAX_VALUE;
        while (i < indices1.size() && j < indices2.size()) {
            int index1 = indices1.get(i);
            int index2 = indices2.get(j);
            shortest = Math.min(shortest, Math.abs(index1-index2));
            if (index1 < index2) {
                i++;
            } else {
                j++;
            }
        }
        return shortest;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */

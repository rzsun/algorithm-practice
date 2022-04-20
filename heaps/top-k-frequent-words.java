class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> counts = new HashMap<>();
        
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> sorted = new PriorityQueue<>(
            (a, b) ->  {
                if (a.getValue() == b.getValue()) {
                    return a.getKey().compareTo(b.getKey());
                }
                return b.getValue() - a.getValue();
            }
        );
        sorted.addAll(counts.entrySet());
        
        List<String> results = new ArrayList<>();
        while (!sorted.isEmpty() && k-- > 0) {
            results.add(sorted.poll().getKey());
        }
        return results;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        
        Queue<int[]> heap = new PriorityQueue<>((a,b) -> (b[1] - a[1]));
        
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            heap.add(new int[] {entry.getKey(), entry.getValue()});
        }
        
        int[] results = new int[k];
        for (int i = 0; i < k; i++) {
            results[i] = heap.poll()[0];
        }
        return results;
    }
}

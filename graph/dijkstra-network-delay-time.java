class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        // put all edges in a map
        Map<Integer, Map<Integer, Integer>> edges = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int source = times[i][0];
            int target = times[i][1];
            int distance = times[i][2];
            
            if (!edges.containsKey(source)) {
                edges.put(source, new HashMap());
            }
            edges.get(source).put(target, distance);
        }
        
        // stores all distances from k to n
        Map<Integer, Integer> distances = new HashMap<>();
        
        // priority heap to always get node with min distance from k
        Queue<int[]> heap = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
        heap.add(new int[]{k, 0});
        Set<Integer> visited = new HashSet<>();
        
        while (heap.peek() != null) {
            int[] currentArray = heap.poll();
            
            int target = currentArray[0];
            int distance = currentArray[1];
            
            // dont revisit same node
            if (visited.contains(target)) {
                continue;
            }
            visited.add(target);
            
            // put min distance
            distances.put(target, distance);
            
            if (!edges.containsKey(target)) {
                continue;
            }
            
            // add distance from K + edge distance to get neighbor's distances from K to min heap
            for (Map.Entry<Integer, Integer> entry : edges.get(target).entrySet()) {
                heap.offer(new int[]{entry.getKey(), distance + entry.getValue()});
            }
        }
        
        if (distances.keySet().size() != n) {
            return -1;
        }
        int max = -1;
        for (Integer i : distances.values()) {
            max = Math.max(i, max);
        }
        return max;
    }
}

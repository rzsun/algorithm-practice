class Solution {
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        // store all X coordinates in List
        List<Integer> xs = new ArrayList<>();
        for (int[] b : buildings) {
            xs.add(b[0]);
            xs.add(b[1]);
        }
        Collections.sort(xs);
        Arrays.sort(buildings, (a,b)->a[0]-b[0]);
        
        // heap to keep track of tallest building
        // top element will be our "current" height
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->b[2]-a[2]);
        
        int i = 0;
        int prevHeight = 0;
        List<List<Integer>> results = new ArrayList<>();
        
        // iterate over all X coordinates
        for (Integer x : xs) {
            
            // add all possible buildings that have "started" before point x
            while (i < buildings.length && buildings[i][0] <= x) {
                heap.offer(buildings[i]);
                i++;
            }
            
            // remove all buildings that have "expired" before point x
            while (!heap.isEmpty() && heap.peek()[1] <= x) {
                heap.remove();
            }
            
            // if current height is different than previous height
            // then we have a new point to add to skyline
            int curHeight = 0;
            if (!heap.isEmpty()) {
                curHeight = heap.peek()[2];
            }
            if (curHeight != prevHeight) {
                results.add(List.of(x, curHeight));
                prevHeight = curHeight;
            }
        }
        
        return results;
    }
}

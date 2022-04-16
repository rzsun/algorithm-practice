class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        if (points.length == 0) return 0;
        
        Set<String> visited = new HashSet<>();
        
        // storing distance, row, col
        PriorityQueue<int[]> frontier = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        frontier.offer(new int[]{0, points[0][0], points[0][1]});
        
        int total = 0;
        
        while (visited.size() < points.length) {
            int[] top = frontier.poll();
            int[] current = new int[]{top[1], top[2]};
            if (visited.contains(pointToString(current))) {
                continue;
            }
            
            total += top[0];
            visited.add(pointToString(current));
            
            for (int[] point : points) {
                if (!visited.contains(pointToString(point))) {
                    int distance = distance(current, point);
                    frontier.offer(new int[]{distance, point[0], point[1]});
                }
            }
        }
        
        return total;
    }
    
    public String pointToString(int[] p) {
        return p[0]+"_"+p[1];
    }
    
    public int distance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}

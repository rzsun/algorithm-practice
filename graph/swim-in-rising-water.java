class Solution {
    
    static final int[][] DIRS = new int[][]{
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0},
    };
    
    public int swimInWater(int[][] grid) {
        
        // {height, i, j}
        PriorityQueue<int[]> frontier = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Set<Integer> visited = new HashSet<>();
        
        int time = 0;
        frontier.add(new int[]{grid[0][0], 0, 0});
        visited.add(pointToKey(0, 0));
        
        while (true) {
            int[] cur = frontier.poll();
            int height = cur[0];
            int i = cur[1];
            int j = cur[2];
            
            if (i == grid.length - 1 &&
               j == grid[0].length - 1) {
                return height;
            }
            
            time = Math.max(time, cur[0]);
            
            for (int n = 0; n < DIRS.length; n++) {
                int i2 = i + DIRS[n][0];
                int j2 = j + DIRS[n][1];
                
                if (visited.contains(pointToKey(i2, j2)) ||
                    i2 < 0 || i2 >= grid.length ||
                    j2 < 0 || j2 >= grid[0].length) {
                    continue;
                }
                frontier.offer(new int[]{
                    Math.max(height, grid[i2][j2]), i2, j2});
                visited.add(pointToKey(i2, j2));
            }
        }
    }
    
    public int pointToKey(int i, int j) {
        return i*397 ^ j;
    }
}

class Solution {
    
    static final int[][] DIRS = new int[][] {
        {0, -1},
        {0, 1},
        {1, 0},
        {-1, 0}
    };
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacificFlow = canFlow(
            createEdges(0, 0, heights.length, heights[0].length), heights);
        
        boolean[][] atlanticFlow = canFlow(
            createEdges(heights.length - 1, heights[0].length - 1,
                        heights.length, heights[0].length), heights);
        
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[0].length; c++) {
                if (pacificFlow[r][c] && atlanticFlow[r][c]) {
                    result.add(List.of(r, c));
                }
            }
        }
        return result;
    }
    
    public Deque<int[]> createEdges(int r, int c, int maxR, int maxC) {
        Deque<int[]> frontier = new ArrayDeque<>();
        for (int i = 0; i < maxR; i++) {
            frontier.addLast(new int[]{i, c});
        }
        for (int i = 0; i < maxC; i++) {
            frontier.addLast(new int[]{r, i});
        }
        return frontier;
    }
    
    public boolean[][] canFlow(Deque<int[]> frontier, int[][] heights) {
        
        boolean[][] result = new boolean[heights.length][heights[0].length];
        
        while (!frontier.isEmpty()) {
            int[] point = frontier.pollFirst();
            int r = point[0];
            int c = point[1];
            if (result[r][c]) {
                continue;
            }
            result[r][c] = true;
            
            for (int[] dir : DIRS) {
                int r1 = r + dir[0];
                int c1 = c + dir[1];
                
                if (r1 >= 0 && r1 < heights.length &&
                    c1 >= 0 && c1 < heights[0].length && 
                    !result[r1][c1] && heights[r1][c1] >= heights[r][c]) {
                    
                    frontier.addLast(new int[]{r1, c1});
                }
            }
        }
        return result;
    }
    
    
}

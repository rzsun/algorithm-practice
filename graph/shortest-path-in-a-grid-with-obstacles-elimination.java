class Solution {
    
    public static final int[][] DIRS = new int[][]{
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    
    public int shortestPath(int[][] grid, int k) {
        boolean[][][] explored = new boolean[grid.length][grid[0].length][k+1];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{0, 0, k}); // row, col, remaining
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.pollFirst();
                
                int row = cur[0]; 
                int col = cur[1]; 
                int remaining = cur[2];
                if (row == grid.length - 1 && col == grid[0].length - 1) {
                    return steps;
                }
                
                for (int[] dir : DIRS) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    int newRemaining = remaining;
                    if (newRow < 0 || newRow >= grid.length || 
                        newCol < 0 || newCol >= grid[0].length) {
                        continue;
                    }
                    if (grid[newRow][newCol] == 1) {
                        newRemaining--;
                    }
                    if (newRemaining >= 0 && !explored[newRow][newCol][newRemaining]) {
                        explored[newRow][newCol][newRemaining] = true;
                        queue.addLast(new int[]{newRow, newCol, newRemaining});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}

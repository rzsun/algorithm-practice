class Solution {
    
    public static final int[][] DIRS = new int[][]{
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    
    public int orangesRotting(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        
        Deque<int[]> stack = new ArrayDeque<>();
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (grid[row][col] == 2) {
                    stack.push(new int[]{row, col});
                }
            }
        }
        
        Deque<int[]> newStack = new ArrayDeque<>();
        int currentMinute = 0;
        while (!stack.isEmpty() || !newStack.isEmpty()) {
            int[] coords = stack.poll();
            for (int i = 0; i < DIRS.length; i++) {
                int newRow = coords[0] + DIRS[i][0];
                int newCol = coords[1] + DIRS[i][1];
                if (isFresh(grid, newRow, newCol)) {
                    grid[newRow][newCol] = 2;
                    newStack.push(new int[]{newRow, newCol});
                }
            }
            if (stack.isEmpty()) {
                if (!newStack.isEmpty()) {
                    stack = newStack;
                    currentMinute++;
                }
                newStack = new ArrayDeque<>();
            }
        }
        
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (grid[row][col] == 1) {
                    return -1;
                }
            }
        }
        
        return currentMinute;
        
    }
    
    public boolean isFresh(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length ||
           col < 0 || col >= grid[0].length) {
            return false;
        }
        return grid[row][col] == 1;
    }
}

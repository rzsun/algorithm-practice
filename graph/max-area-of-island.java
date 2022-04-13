class Solution {
    public static final int[][] DIRS = new int[][]{
        {0, -1},
        {0, 1},
        {-1, 0},
        {1, 0}
    };
    
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int max = 0;
        Deque<int[]> cur = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int size = 0;
                if (checkIsland(visited, grid, i, j)) {
                    cur.add(new int[]{i, j});
                    size++;
                    while (!cur.isEmpty()) {
                        int[] coords = cur.poll();
                        int row = coords[0];
                        int col = coords[1];
                        for (int k = 0; k < DIRS.length; k++) {
                            int newRow = row + DIRS[k][0];
                            int newCol = col + DIRS[k][1];
                            if (checkIsland(visited, grid, newRow, newCol)) {
                                size++;
                                cur.add(new int[]{newRow, newCol});
                            }
                        }
                    }
                }
                max = Math.max(size, max);
            }
        }
        return max;
    }
    
    public boolean checkIsland(boolean[][] visited, int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length) {
            return false;
        }
        if (col < 0 || col >= grid[0].length) {
            return false;
        }
        if (visited[row][col]) {
            visited[row][col] = true;
            return false;
        }
        visited[row][col] = true;
        return grid[row][col] == 1;
    }
}

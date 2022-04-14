class Solution {
    
    static int INF = 2147483647;
    
    static int[][] DIRS = new int[][]{
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    
    public void wallsAndGates(int[][] rooms) {
        Deque<int[]> curLevel = new ArrayDeque<>();
        for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col < rooms[0].length; col++) {
                if (rooms[row][col] == 0) {
                    curLevel.add(new int[]{row, col});
                }
            }
        }
        int level = 1;
        Deque<int[]> nextLevel = new ArrayDeque<>();
        while (!curLevel.isEmpty() || !nextLevel.isEmpty()) {
            int[] coords = curLevel.poll();
            for (int i = 0; i < DIRS.length; i++) {
                int newRow = coords[0] + DIRS[i][0];
                int newCol = coords[1] + DIRS[i][1];
                if (isValid(rooms, newRow, newCol)) {
                    rooms[newRow][newCol] = level;
                    nextLevel.push(new int[]{newRow, newCol});
                }
            }
            if (curLevel.isEmpty()) {
                if (!nextLevel.isEmpty()) {
                    curLevel = nextLevel;
                    level++;
                }
                nextLevel = new ArrayDeque<>();
            }
        }
    }
    
    public boolean isValid(int[][] rooms, int row, int col) {
        if (row < 0 || row >= rooms.length ||
           col < 0 || col >= rooms[0].length) {
            return false;
        }
        return rooms[row][col] == INF;
    }
}

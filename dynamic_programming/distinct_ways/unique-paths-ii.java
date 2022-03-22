class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        // check edge cases
        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        if (n == 0) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        
        // populate edges, if hit obstacle => can no longer continue
        int[][] ways = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 0) {
                break;
            }
            ways[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] != 0) {
                break;
            }
            ways[0][i] = 1;
        }
        
        // traverse board
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    ways[i][j] = 0;
                    continue;
                }
                ways[i][j] = ways[i-1][j] + ways[i][j-1];
            }
        }
        return ways[m-1][n-1];
    }
}

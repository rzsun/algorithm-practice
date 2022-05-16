class Solution {
    
    static final int[][] DIRS = new int[][]{
        {0, -1},
        {0, 1},
        {-1, 0},
        {1, 0}
    };
    
    public int longestIncreasingPath(int[][] matrix) {
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 1;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                max = Math.max(max,
                               longest(matrix, r, c, cache));
            }
        }
        return max;
    }
    
    public int longest(int[][] m, 
                       int r, 
                       int c,
                       int[][] cache) {
        if (cache[r][c] != 0) {
            return cache[r][c];
        }
        int max = 0;
        for (int i = 0; i < DIRS.length; i++) {
            int r1 = r + DIRS[i][0];
            int c1 = c + DIRS[i][1];
            if (inBounds(m, r1, c1)) {
                if (m[r1][c1] > m[r][c]) {
                    max = Math.max(longest(m, r1, c1, cache), max);
                }
            }
        }
        int res = 1 + max;
        cache[r][c] = res;
        return res;
    }
    
    public boolean inBounds(int[][] m, int r, int c) {
        if (r < 0 || r >= m.length) {
            return false;
        }
        if (c < 0 || c >= m[0].length) {
            return false;
        }
        return true;
    }
}

class Solution {
    public int maximalSquare(char[][] matrix) {
        int col = matrix[0].length;
        int row = matrix.length;
        
        int[][] max = new int[row][col];
        int res = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] != '1') {
                    continue;
                }
                int left = 0;
                int up = 0;
                int leftUp = 0;
                
                if (i - 1 >= 0) {
                    left = max[i-1][j];
                }
                if (j - 1 >= 0) {
                    up = max[i][j - 1];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    leftUp = max[i-1][j-1];
                }
                    
                max[i][j] = 1 + Math.min(
                    left,
                    Math.min(up, leftUp)
                );
                
                res = Math.max(max[i][j], res);
            }
        }
        return res * res;
    }
}

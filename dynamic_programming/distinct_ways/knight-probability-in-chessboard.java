class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        int[][] moves = {
            {-1, -2},
            {1, -2},
            {-1, 2},
            {1, 2},
            {-2, -1},
            {-2, 1},
            {2, -1},
            {2, 1}
        };
        
        double[][][] probability = new double[k+1][n][n];
        probability[0][row][column] = 1;
        
        for (int i = 1; i <= k; ++i) {
            for (int x = 0; x < n; ++x) {
                for (int y = 0; y < n; ++y) {
                    
                    for (int j = 0; j < moves.length; ++j) {
                        
                        int newX = x + moves[j][0];
                        int newY = y + moves[j][1];
                        
                        if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                            probability[i][newX][newY] += (probability[i - 1][x][y])/8.0;
                        }
                    }
                    
                }
            }
        }
        double result = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                result += probability[k][i][j];
            }
        }
        return result;
    }
}

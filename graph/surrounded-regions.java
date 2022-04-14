class Solution {
    
    int[][] DIRS = new int[][]{
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    
    public void solve(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == 'O') {
                markBoardered(board, row, 0);
            }
            if (board[row][board[0].length - 1] == 'O') {
                markBoardered(board, row, board[0].length - 1);
            }
        }
        
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == 'O') {
                markBoardered(board, 0, col);
            }
            if (board[board.length - 1][col] == 'O') {
                markBoardered(board, board.length - 1, col);
            }
        }
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
                if (board[row][col] == 'Y') {
                    board[row][col] = 'O';
                }
            }
        }
    }
    
    public void markBoardered(char[][] board, int row, int col) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{row, col});
        while (!stack.isEmpty()) {
            int[] cur = stack.poll();
            board[cur[0]][cur[1]] = 'Y';
            for (int i = 0; i < DIRS.length; i++) {
                int curRow = cur[0] + DIRS[i][0];
                int curCol = cur[1] + DIRS[i][1];
                if (checkPosition(board, curRow, curCol)) {
                    stack.push(new int[]{curRow, curCol});
                }
            }
        }
    }
    
    public boolean checkPosition(char[][] board, int row, int col) {
        return !(row < 0 || row >= board.length || 
                 col < 0 || col >= board[0].length ||
                 board[row][col] != 'O');
    }
}

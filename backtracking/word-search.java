class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean result = wordSearch(board, j, i, word, new HashSet<>());
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean wordSearch(char[][] board, int row, int col,
                      String word, Set<Map.Entry> seen) {
        if (seen.size() == word.length()) {
            return true;
        }
        if (row >= board[0].length || row < 0) {
            return false;
        }
        if (col >= board.length || col < 0) {
            return false;
        }
        Map.Entry<Integer, Integer> pair = Map.entry(row, col);
        if (seen.contains(pair)) {
            return false;
        }
        
        if (board[col][row] == word.charAt(seen.size())) {
            seen.add(pair);
            if (wordSearch(board, row + 1, col, word, seen)
                || wordSearch(board, row - 1, col, word, seen)
                || wordSearch(board, row, col + 1, word, seen)
                || wordSearch(board, row, col - 1, word, seen)) {
                return true;
            }
            seen.remove(pair);
        }
        
        return false;
    }
}

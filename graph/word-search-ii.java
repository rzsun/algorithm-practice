class Solution {
    
    class PrefixCache {
        Set<String> prefixes;
        Set<String> words;
        
        PrefixCache() {
            prefixes = new HashSet<>();
            words = new HashSet<>();
        }
        
        public void addWord(String word) {
            for (int i = 1; i < word.length(); i++) {
                prefixes.add(word.substring(0, i));
            }
            words.add(word);
        }
    }
    
    public static final int[][] DIRS = new int[][]{
        {0, -1},
        {0, 1},
        {-1, 0},
        {1, 0}
    };
    
    public List<String> findWords(char[][] board, String[] words) {
        PrefixCache cache = new PrefixCache();
        for (String word : words) {
            cache.addWord(word);
        }
        
        Set<String> result = new HashSet<>();
        boolean[][] seen = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                recurse(board, seen, row, col, result, cache, String.valueOf(board[row][col]));
            }
        }
        return new ArrayList<>(result);
    }
    
    public void recurse(char[][] board, boolean[][] seen, int row, int col, 
                        Set<String> result, 
                        PrefixCache cache, String current) {
        if (cache.words.contains(current)) {
            result.add(current);
        }
        if (!cache.prefixes.contains(current)) {
            return;
        }
        seen[row][col] = true;
        for (int i = 0; i < DIRS.length; i++) {
            int row1 = row + DIRS[i][0];
            int col1 = col + DIRS[i][1];
            if (check(board, seen, row1, col1)) {
                recurse(board, seen, row1, col1, 
                        result, cache, current + board[row1][col1]);
            }
        }
        seen[row][col] = false;
    }
    
    public boolean check(char[][] board, boolean[][] seen, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length &&
            !seen[row][col];
    }
}

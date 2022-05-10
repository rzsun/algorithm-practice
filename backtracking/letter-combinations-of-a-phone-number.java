class Solution {
    
    static final char[][] mapping = new char[][] {
        {'0'},
        {'1'},
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
    };
    
    public int numAt(String digits, int pos) {
        return Character.getNumericValue(digits.charAt(pos));
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits.length() == 0) {
            return results;
        }
        
        Deque<String> frontier = new ArrayDeque<>();
        for (char c : mapping[numAt(digits, 0)]) {
            frontier.addFirst(String.valueOf(c));
        }
        
        while (!frontier.isEmpty()) {
            String cur = frontier.pollFirst();
            if (cur.length() == digits.length()) {
                results.add(cur);
                continue;
            }
            for (char c : mapping[numAt(digits, cur.length())]) {
                frontier.addFirst(cur + String.valueOf(c));
            }
        }
        
        return results;
    }
}

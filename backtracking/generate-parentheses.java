class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        backtrack(results, "", 0, 0, n);
        return results;
    }
    
    public void backtrack(List<String> results, String cur, int left, int right, int n) {
        
        if (cur.length() == n*2) {
            results.add(cur);
            return;
        }
        
        if (left < n) {
            backtrack(results, cur + "(", left + 1, right, n);
        }
        if (right < left) {
            backtrack(results, cur + ")", left, right + 1, n);
        }
        
    }
}

class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0;
        
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.addLast(c);
            }
            if (c == ')') {
                if (stack.isEmpty()) {
                    count++;
                } else {
                    stack.pollLast();
                }
            }
        }
        count += stack.size();
        return count;
    }
}

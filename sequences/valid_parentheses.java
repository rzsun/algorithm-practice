class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.push(s.charAt(i));
            } else if (cur == ')') {
                if (stack.size() == 0) {
                    return false;
                }
                if (stack.pop() != '(') {
                    return false;
                }
            } else if (cur == ']') {
                if (stack.size() == 0) {
                    return false;
                }
                if (stack.pop() != '[') {
                    return false;
                }
            } else if (cur == '}') {
                if (stack.size() == 0) {
                    return false;
                }
                if (stack.pop() != '{') {
                    return false;
                }
            }
        }
        
        return stack.size() == 0;
    }
}

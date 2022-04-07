class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-")
               && !token.equals("*") && !token.equals("/")) {
                stack.addLast(Integer.valueOf(token));
                continue;
            }
            
            int a = stack.pollLast();
            int b = stack.pollLast();
            
            if (token.equals("+")) {
                stack.addLast(a + b);
            } else if (token.equals("-")) {
                stack.addLast(b - a);
            } else if (token.equals("*")) {
                stack.addLast(b * a);
            } else if (token.equals("/")) {
                stack.addLast(b / a);
            }
        }
        return stack.pollLast();
    }
}

class Solution {
    public String minRemoveToMakeValid(String s) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        Set<Integer> invalid = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.addLast(i);
            }
            if (c == ')') {
                if (stack.isEmpty()) {
                    invalid.add(i);
                } else {
                    stack.pollLast();
                }
            }
        }
        while (!stack.isEmpty()) {
            invalid.add(stack.pollLast());
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!invalid.contains(i)) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}

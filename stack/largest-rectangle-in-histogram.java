class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int max = 0;
        
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(heights[i], max);
            int start = i;
            
            // go through stack to find all bars that stopped "growing"
            while (!stack.isEmpty() && stack.getLast()[0] > heights[i]) {
                max = Math.max(max, stack.getLast()[0] * (i - stack.getLast()[1]));
                
                // keep track of how far back current bar can grow
                start = stack.getLast()[1];
                stack.removeLast();
            }
            stack.addLast(new int[]{heights[i], start});
        }
        
        // calculate max for remainder of stack
        while (!stack.isEmpty()) {
            max = Math.max(max, stack.getLast()[0] * (heights.length - stack.getLast()[1]));
            stack.removeLast();
        }
        return max;
        
    }
}

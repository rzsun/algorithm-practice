class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peekLast()[0] < temperatures[i]) {
                int[] day = stack.pollLast();
                results[day[1]] = i - day[1];
            }
            stack.addLast(new int[]{temperatures[i], i});
        }
        return results;
    }
}

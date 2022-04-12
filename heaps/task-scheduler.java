class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskCounts = new HashMap<>();
        for (char task : tasks) {
            taskCounts.put(
                task,
                taskCounts.getOrDefault(task, 0) + 1
            );
        }
        
        PriorityQueue<Integer> pendingTasks = new PriorityQueue<>((a, b) -> b - a);
        for (Integer count : taskCounts.values()) {
            pendingTasks.offer(count);
        }
        
        int time = 0;
        Deque<int[]> taskQueue = new ArrayDeque<>();
        while (!pendingTasks.isEmpty() || !taskQueue.isEmpty()) {
            if (!pendingTasks.isEmpty()) {
                int remaining = pendingTasks.poll() - 1;
                if (remaining > 0) {
                    taskQueue.addLast(new int[]{remaining, time + n});
                }
            }
            while (!taskQueue.isEmpty() && time >= taskQueue.peekFirst()[1]) {
                pendingTasks.offer(taskQueue.pollFirst()[0]);
            }
            time++;
        }
        
        return time;
    }
}

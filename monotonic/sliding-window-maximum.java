class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int start = 0;
        int end = 0;
        int[] results = new int[nums.length - k + 1];
        while (end < nums.length) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[end]) {
                queue.removeLast();
            }
            queue.addLast(end);
            if (queue.peekFirst() < start) {
                queue.removeFirst();
            }
            results[start] = nums[queue.peekFirst()];
            if (end - start + 1 >= k) {
                results[start] = nums[queue.peekFirst()];
                start++;
            }
            end++;
        }
        return results;
    }
}

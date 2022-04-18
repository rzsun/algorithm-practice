class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> mins = new ArrayDeque<>();
        Deque<Integer> maxs = new ArrayDeque<>();
        int low = 0;
        int longest = 0;
        
        for (int high = 0; high < nums.length; high++) {
            while (!mins.isEmpty() && nums[high] <= nums[mins.peekLast()]) {
                mins.removeLast();
            }
            while (!maxs.isEmpty() && nums[high] >= nums[maxs.peekLast()]) {
                maxs.removeLast();
            }
            mins.addLast(high);
            maxs.addLast(high);
            
            while (nums[maxs.peekFirst()] - nums[mins.peekFirst()] > limit) {
                low++;
                if (mins.peekFirst() < low) {
                    mins.removeFirst();
                }
                if (maxs.peekFirst() < low) {
                    maxs.removeFirst();
                }
            }
            longest = Math.max(longest, high - low + 1);
        }
        return longest;
    }
}

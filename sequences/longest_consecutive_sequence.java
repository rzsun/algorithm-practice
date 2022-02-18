class Solution {
    
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);
        Set<Integer> visited = new HashSet<>();
        
        int maxStreak = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (visited.contains(cur)) {
                continue;
            }
            int streak = 1;
            int prev = cur - 1;
            while (set.contains(prev)) {
                streak++;
                visited.add(prev);
                prev--;
            }
            int next = cur + 1;
            while (set.contains(next)) {
                streak++;
                visited.add(next);
                next++;
            }
            maxStreak = Math.max(maxStreak, streak);
        }
        return maxStreak;
    }
}

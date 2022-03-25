class Solution {
    public boolean canJump(int[] nums) {
        
        boolean[] reachable = new boolean[nums.length];
        reachable[0] = true;
        
        for (int i = 0; i < nums.length; i++) {
            if (!reachable[i]) {
                continue;
            }
            int distance = nums[i];
            for (int j = i + 1; j <= i + distance && j < nums.length; j++) {
                reachable[j] = true;
            }
        }
        
        return reachable[nums.length - 1];
    }
}

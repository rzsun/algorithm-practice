class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] combos = new int[target + 1];
        combos[0] = 1;
        
        for (int i = 0; i <= target; ++i) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    combos[i] += combos[i - nums[j]];
                }
            }
        }
        return combos[target];
    }
}

class Solution {
    public static boolean canPartition(int[] nums) {

        int total = 0;
        for (int i = 0; i < nums.length; ++i) {
            total += nums[i];
        }

        if (total % 2 == 1) {
            return false;
        }

        int target = total / 2;

        boolean[][] combos = new boolean[nums.length + 1][target + 1];
        combos[0][0] = true;

        for (int i = 0; i <= nums.length; ++i) {
            combos[i][0] = true;
        }

        for (int i = 1; i <= nums.length; ++i) {
            for (int j = 1; j <= target; ++j) {
                combos[i][j] = combos[i - 1][j];
                if (j - nums[i - 1] >= 0) {
                    combos[i][j] = combos[i][j] || combos[i-1][j - nums[i - 1]];
                }
            }
        }

        return combos[nums.length][target];
    }
}

class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int m = 1000000007;
        
        int[][] ways = new int[n + 1][target + 1];
        ways[0][0] = 1; // ways[dice][target] => ways
        
        for (int dice = 1; dice <= n; ++dice) {
            for (int num = 1; num <= target; ++num) {
                for (int face = 1; face <= k; ++face) {
                    if (num - face >= 0) {
                        ways[dice][num] = (ways[dice][num] + ways[dice - 1][num - face]) % m;
                    }
                }
            }
        }
        
        return ways[n][target];
    }
}

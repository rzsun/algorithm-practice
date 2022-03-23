class Solution {
    public int numTrees(int n) {
        // for each node, numTrees = numTrees(left) * numTrees(right)
        int[] dp = new int[n + 1];
        return numTreesRecursive(dp, n);
    }
    
    public int numTreesRecursive(int[] dp, int n) {
        if (dp[n] != 0) {
            return dp[n];
        }
        if (n == 0) {
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += numTreesRecursive(dp, i-1) * numTreesRecursive(dp, n - i);
        }
        dp[n] = sum;
        return sum;
    }
}

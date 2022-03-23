class Solution {
    public int numTrees(int n) {
        // for each node, numTrees = numTrees(left) * numTrees(right)
        //int[] dp = new int[n + 1];
        //return numTreesRecursive(dp, n);
        
        return numTrees2(n);
    }
    
    // top down
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
    
    // bottom up
    public int numTrees2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j > 0; j--) {
                sum += dp[j - 1] * dp[i - j];
            }
            dp[i] = sum;
        }
        return dp[n];
    }
}

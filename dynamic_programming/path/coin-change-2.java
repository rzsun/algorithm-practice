class Solution {
    
    public int change(int amount, int[] coins) {
        int[][] memo = new int[coins.length][amount+1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(0, amount, coins, memo);
    }
    
    public int dp(int start, 
                  int amount, 
                  int[] coins,
                  int[][] memo) {
        
        if (start < 0 || start >= coins.length || amount < 0) {
            return 0;
        }
        
        if (amount == 0) {
            return 1;
        }
        
        if (memo[start][amount] != -1) {
            return memo[start][amount];
        }
        
        int ways = 
            dp(start, amount - coins[start], coins, memo) + 
            dp(start + 1, amount, coins, memo);
        
        memo[start][amount] = ways;
        return ways;
    }
}

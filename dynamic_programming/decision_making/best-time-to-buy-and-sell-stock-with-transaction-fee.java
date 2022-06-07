class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        
        int[] sell = new int[n];
        int[] hold = new int[n];
        int[] skip = new int[n];
        
        sell[0] = 0;
        hold[0] = 0 - prices[0];
        skip[0] = 0;
                
        for (int i = 1; i < n; i++) {
            sell[i] = hold[i-1] + prices[i] - fee;
            
            hold[i] = Math.max(hold[i-1], skip[i-1] - prices[i]);
            hold[i] = Math.max(hold[i], sell[i-1] - prices[i]);
            
            skip[i] = Math.max(skip[i-1], sell[i-1]);
        }
        
        return Math.max(
            hold[n-1], Math.max(skip[n-1], sell[n-1])
        );
    }
}

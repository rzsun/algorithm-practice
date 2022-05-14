class Solution {
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        // max profit resting at day i
        int[] rest = new int[n];
        // max profit selling at day i
        int[] sold = new int[n];
        // max profit on cooldown at day i
        int[] cooldown = new int[n];
        
        int bestBuy = Integer.MIN_VALUE; // O(n^2) --> O(n) optimization, only need to calculate rest[j] - prices[j] once
        for (int i = 1; i < n; i++) {
            rest[i] = Math.max(rest[i-1], cooldown[i-1]);
            bestBuy = Math.max(bestBuy, rest[i-1] - prices[i-1]);
            sold[i] = bestBuy + prices[i];
            /*for (int j = 0; j < i; j++) {
                sold[i] = Math.max(sold[i], 
                                   rest[j] - prices[j] + prices[i]);
            }*/
            cooldown[i] = sold[i-1];
        }
        return Math.max(Math.max(rest[n-1], sold[n-1]), cooldown[n-1]);
    }
}

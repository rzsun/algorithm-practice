class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        
        // max profit with holding with # of transactions
        int[][] hold = new int[prices.length][2+1];
        int[][] sell = new int[prices.length][2+1];
        int[][] skip = new int[prices.length][2+1];
        
        for (int i = 0; i <= 2; i++) {
            hold[0][i] = -prices[0];
        }
        
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            for (int j = 0; j <= 2; j++) {
                int maxHold = hold[i-1][j];
                maxHold = Math.max(maxHold, sell[i-1][j] - price);
                maxHold = Math.max(maxHold, skip[i-1][j] - price);   
                hold[i][j] = maxHold;
                
                int maxSell = sell[i-1][j];
                if (j > 0) {
                    maxSell = Math.max(maxSell, hold[i-1][j-1] + price);
                }
                sell[i][j] = maxSell;
                
                int maxSkip = skip[i-1][j];
                maxSkip = Math.max(maxSkip, sell[i-1][j]);
                skip[i][j] = maxSkip;
                
                max = Math.max(maxHold, maxSell);
                max = Math.max(max, maxSkip);
            }
        }
        
        return max;
    }
}

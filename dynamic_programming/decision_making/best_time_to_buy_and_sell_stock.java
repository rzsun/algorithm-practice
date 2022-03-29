class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int price = prices[0];
        
        for (int i = 0; i < prices.length; i++) {
            int profit = prices[i] - price;
            maxProfit = Math.max(profit, maxProfit);
            if (profit < 0) {
                price = prices[i];
            }
        }
        
        return maxProfit;
    }
}

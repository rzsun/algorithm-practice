class Solution {
    public int maxProfit(int[] prices) {
        
        int[] hold = new int[prices.length];
        int[] sold = new int[prices.length];
        
        hold[0] = -prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            hold[i] = Math.max(
                hold[i-1], sold[i-1]-prices[i]);
            sold[i] = Math.max(
                hold[i] + prices[i], sold[i-1]);
        }
        return sold[prices.length-1];
    }
}

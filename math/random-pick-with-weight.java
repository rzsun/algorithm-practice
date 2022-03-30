class Solution {
    
    private int[] prefixSums;
    private int totalSum = 0;
    
    public Solution(int[] w) {
        prefixSums = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            totalSum += w[i];
            prefixSums[i] = totalSum;
        }
    }
    
    public int pickIndex() {
        
        double target = this.totalSum * Math.random();
        
        int low = 0;
        int high = prefixSums.length;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (prefixSums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

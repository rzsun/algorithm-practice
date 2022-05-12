class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0;
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < timeSeries.length; i++) {
            int cur = timeSeries[i];
            if (cur > end) {
                total += end - start;
                start = cur;
            }
            end = cur + duration;
        }
        return total + (end-start);
    }
}

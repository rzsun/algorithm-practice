class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        
        int newLow = newInterval[0];
        int newHigh = newInterval[1];
        
        List<int[]> results = new ArrayList<>();
        
        int i = 0;
        while (i < intervals.length && newLow > intervals[i][1]) {
            results.add(intervals[i]);
            i++;
        }
        
        while (i < intervals.length && newHigh >= intervals[i][0]) {
            newLow = Math.min(newLow, intervals[i][0]);
            newHigh = Math.max(newHigh, intervals[i][1]);
            i++;
        }
        results.add(new int[]{newLow, newHigh});
        
        while (i < intervals.length) {
            results.add(intervals[i]);
            i++;
        }
        
        int[][] r = new int[results.size()][];

        return results.toArray(r);
    }
}

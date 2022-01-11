class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> result = new ArrayList<>();
        
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (result.size() == 0) {
                result.add(interval);
            } else {
                int curEnd = result.get(result.size() - 1)[1];
                if (curEnd >= interval[0]) {
                    result.get(result.size() - 1)[1] = Math.max(curEnd, interval[1]);
                } else {
                    result.add(interval);
                }
            }   
        }
        
        return result.toArray(new int[result.size()][2]);

    }
}

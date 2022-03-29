class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        
        Arrays.sort(points, new HeadComparator());
        
        int count = 1;
        int start = points[0][0];
        int end = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            
            int newStart = points[i][0];
            int newEnd = points[i][1];
            
            if (newStart > end) {
                start = newStart;
                end = newEnd;
                count++;
            } else {
                start = Math.max(start, newStart);
                end = Math.min(end, newEnd);
            }
        }
        return count;
    }
    
    static class HeadComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]);
        }
    }
}

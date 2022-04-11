class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(new DistanceComparator());
        for (int[] point : points) {
            heap.offer(point);
        }
        
        int[][] results = new int[k][2];
        while (k-- > 0) {
            results[k] = heap.poll();
        }
        return results;
    }
    
    static class DistanceComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            double aDistance = Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2));
            double bDistance = Math.sqrt(Math.pow(b[0], 2) + Math.pow(b[1], 2));
            if (aDistance - bDistance > 0) {
                return 1;
            } else if (aDistance - bDistance < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

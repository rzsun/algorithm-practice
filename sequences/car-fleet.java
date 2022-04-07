class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] cars = new double[position.length][2]; // [][pos, speed]
        for (int i = 0; i < position.length; i++) {
            cars[i] = new double[] {position[i], speed[i]};
        }
        Arrays.sort(cars, new CarComparator());
        
        int result = 0;
        double maxTime = 0;
        for (int i = cars.length - 1; i >= 0 ; i--) {
            double curTime = (target - cars[i][0])/cars[i][1];
            if (curTime > maxTime) {
                maxTime = curTime;
                result++;
            }
        }
        return result;
    }
    
    // compares pos, then speed
    static class CarComparator implements Comparator<double[]> {
        public int compare(double[] a, double[] b) {
            if (a[0] == b[0]) {
                return Double.compare(a[1], b[1]);
            }
            return Double.compare(a[0], b[0]);
        }
    }
}

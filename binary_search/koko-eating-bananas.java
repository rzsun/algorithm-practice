class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        int low = 1;
        int high = max;
        while (low <= high) {
            if (low == high) {
                return low;
            }
            int mid = (low + high)/2;
            if (canEat(piles, mid, h)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    
    public boolean canEat(int[] piles, int k, int h) {
        int hour = 0;
        for (int i = 0; i < piles.length; i++) {
            hour += piles[i] / k;
            if (piles[i] % k != 0) {
                hour++;
            }
            if (hour > h) {
                return false;
            }
        }
        return true;
    }
}

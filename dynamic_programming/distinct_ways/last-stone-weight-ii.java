class Solution {
    public int lastStoneWeightII(int[] stones) {
        
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        
        boolean[][] sums = new boolean[stones.length + 1][sum + 1]; // if sum is possible
        
        for (int i = 0; i <= stones.length; i++) {
            sums[i][0] = true;
        }
        
        // divide rocks into two piles, get min diff between them
        int min = sum;
        for (int i = 1; i <= stones.length; i++) {
            for (int j = 1; j <= sum; j++) {
                sums[i][j] = sums[i-1][j];
                if (j - stones[i-1] >= 0) {
                    sums[i][j] = sums[i][j] || sums[i-1][j - stones[i-1]];
                    if (sums[i][j]) {
                        min = Math.min(min, Math.abs((sum - j) - j));
                    }
                }
            }
        }
        return min;
    }
}

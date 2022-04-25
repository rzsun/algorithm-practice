class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean found1 = false;
        boolean found2 = false;
        boolean found3 = false;
        for (int i = 0; i < triplets.length; i++) {
            if (triplets[i][0] == target[0] &&
                triplets[i][1] <= target[1] &&
                triplets[i][2] <= target[2]) {
                found1 = true;
            }
            if (triplets[i][0] <= target[0] &&
                triplets[i][1] == target[1] &&
                triplets[i][2] <= target[2]) {
                found2 = true;
            }
            if (triplets[i][0] <= target[0] &&
                triplets[i][1] <= target[1] &&
                triplets[i][2] == target[2]) {
                found3 = true;
            }
        }
        return found1 && found2 && found3;
    }
}

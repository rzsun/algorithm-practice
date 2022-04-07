class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int n = matrix.length;
        final int m = matrix[0].length;
        int low = 0;
        int high = m * n - 1;
        
        while (low <= high) {
            int mid = (high+low)/2;
            int val = matrix[mid/m][mid%m];
            if (val == target) {
                return true;
            }
            if (val < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}

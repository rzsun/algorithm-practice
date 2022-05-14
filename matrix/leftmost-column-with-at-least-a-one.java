/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);
        
        int r = 0;
        int c = cols - 1;
        int result = -1;
        
        while (r < rows && c >= 0) {
            if (binaryMatrix.get(r, c) == 1) {
                result = c;
                c--;
            } else {
                r++;
            }
        }
        return result;
    }
}

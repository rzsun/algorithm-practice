class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int leftBound = 0;
        int rightBound = matrix[0].length - 1;
        
        int upBound = 0;
        int downBound = matrix.length - 1;
        
        List<Integer> results = new ArrayList<>();
        
        int curDirection = 0; // 0 right 1 down 2 left 3 up
        
        int xPos = 0;
        int yPos = 0;
        
        while(true) {
            
            if (curDirection == 0) {
                results.add(matrix[yPos][xPos]);
                if (xPos == rightBound) {
                    if (yPos == downBound) {
                        return results;
                    }
                    curDirection = 1;
                    yPos++;
                    upBound = yPos;
                } else {
                    xPos++;
                }
            }
            
            if (curDirection == 1) {
                results.add(matrix[yPos][xPos]);
                if (yPos == downBound) {
                    if (xPos == leftBound) {
                        return results;
                    }
                    curDirection = 2;
                    xPos--;
                    rightBound = xPos;
                } else {
                    yPos++;
                }
            }
            
            if (curDirection == 2) {
                results.add(matrix[yPos][xPos]);
                if (xPos == leftBound) {
                    if (yPos == upBound) {
                        return results;
                    }
                    curDirection = 3;
                    yPos--;
                    downBound = yPos;
                } else {
                    xPos--;
                }
            }
            
            if (curDirection == 3) {
                results.add(matrix[yPos][xPos]);
                if (yPos == upBound) {
                    if (xPos == rightBound) {
                        return results;
                    }
                    curDirection = 0;
                    xPos++;
                    leftBound = xPos;
                } else {
                    yPos--;
                }
            }
        }
        
    }
}

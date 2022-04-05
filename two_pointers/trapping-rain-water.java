class Solution {
    
    // O(n) time O(n) space
    public int trap1(int[] height) {
        int[] highestLeftWall = new int[height.length];
        int[] highestRightWall = new int[height.length];
        
        int maxWallLeft = 0;
        for (int i = 0; i < height.length; i++) {
            highestLeftWall[i] = maxWallLeft;
            maxWallLeft = Math.max(maxWallLeft, height[i]);
        }
        int maxWallRight = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            highestRightWall[i] = maxWallRight;
            maxWallRight = Math.max(maxWallRight, height[i]);
        }
        
        int trapped = 0;
        
        for (int i = 0; i < height.length; i++) {
            int wall = Math.min(highestLeftWall[i], highestRightWall[i]);
            trapped += Math.max(0, wall - height[i]);          
        }
        return trapped;
    }
    
    // O(n) time O(1) space
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWallLeft = 0;
        int maxWallRight = 0;
        
        int result = 0;
        while (left <= right) {
            int wall = Math.min(maxWallLeft, maxWallRight);
            
            if (maxWallLeft < maxWallRight) {
                result += Math.max(0, wall - height[left]);
                maxWallLeft = Math.max(maxWallLeft, height[left]);
                left++;
            } else {
                result += Math.max(0, wall - height[right]);
                maxWallRight = Math.max(maxWallRight, height[right]);
                right--;
            }
        }
        return result;
    }

}

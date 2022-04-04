
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;
        
        while(start < end) {
            maxArea = Math.max(maxArea, 
                               (end - start) * Math.min(height[end], height[start]));
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        
        return maxArea;
    }
}

class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        
        int[] res = new int[nums.length];
        
        int low = 0;
        int high = nums.length - 1;
        
        int i = nums.length - 1;
        if (a < 0) {
            i = 0;
        }
        
        while (i >= 0 && i < nums.length) {
            int lowQuad = quad(nums[low], a, b, c);
            int highQuad = quad(nums[high], a, b, c);
            
            if (a < 0) {
                if (lowQuad < highQuad) {
                    res[i] = lowQuad;
                    low++;
                } else {
                    res[i] = highQuad;
                    high--;
                }
                i++;
            } else {
                if (lowQuad > highQuad) {
                    res[i] = lowQuad;
                    low++;
                } else {
                    res[i] = highQuad;
                    high--;
                }
                i--;
            }
        }
        return res;
    }
    
    public int quad(int x, int a, int b, int c) {
        return (int)(a * Math.pow(x, 2)) + (b * x) + (c);
    }
}

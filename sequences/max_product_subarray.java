class Solution {
    public int maxProduct(int[] nums) {
        int curMax = nums[0];
        int curMin = nums[0];
        int max = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            
            int num = nums[i];
            
            if (num < 0) {
                int oldMax = curMax;
                curMax = Math.max(num, curMin * num);
                curMin = Math.min(num, oldMax * num);
            } else {
                curMax = Math.max(num, curMax * num);
                curMin = Math.min(num, curMin * num);
            }
            
            max = Math.max(max, curMax);
            
        }
        return max;
    }
}

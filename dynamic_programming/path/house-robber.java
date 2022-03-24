class Solution {
    
    // rob(n) = max(val(n) + rob(n - 2), rob(n - 1))
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        
        int[] robbed = new int[length];
        
        robbed[0] = nums[0];
        robbed[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            robbed[i] = Math.max(nums[i] + robbed[i - 2], robbed[i - 1]);
        }
        
        return robbed[length - 1];
    }
}

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob1(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                        rob1(Arrays.copyOfRange(nums, 1, nums.length)));
        
    }
    
    public int rob1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] robbed = new int[nums.length];
        
        robbed[0] = nums[0];
        robbed[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            robbed[i] = Math.max(nums[i] + robbed[i - 2], robbed[i - 1]);
        }
        return robbed[nums.length - 1];
    }
}

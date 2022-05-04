class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int sum = 0;
        int min = 0;
        
        int low = 0;
        for (int high = 0; high < nums.length; high++) {
            sum += nums[high];
            while (sum >= target) {
                if (min == 0) {
                    min = high - low + 1;
                } else {
                    min = Math.min(high - low + 1, min);
                }
                sum -= nums[low];
                low++;
            }
        }
        
        return min;
    }
}

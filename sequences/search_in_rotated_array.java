class Solution {
    public int search(int[] nums, int target) {
        
        int lower = 0;
        int upper = nums.length - 1;

        if (nums[lower] == target) {
            return lower;
        }
        if (nums[upper] == target) {
            return upper;
        }
        
        while(lower < upper - 1) {
            if (nums[lower] == target) {
                return lower;
            }
            if (nums[upper] == target) {
                return upper;
            }
            
            int mid = (lower + upper)/2;
            if (nums[mid] == target) {
                return mid;
            }
            
            if (nums[lower] < target && target < nums[mid]) {
                upper = mid;
            } else if (nums[mid] < target && target < nums[upper]) {
                lower = mid;
            } else if (nums[mid] >= nums[upper])
                lower = mid;
            else {
                upper = mid;
            }
        }
        
        return -1;
    }
}

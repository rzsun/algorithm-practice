class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        
        int left = 1;
        for (int i =  0; i < nums.length; i++) {
            leftProduct[i] = left;
            left *= nums[i];
        }
        
        int right = 1;
        for (int i =  nums.length - 1; i >= 0; i--) {
            rightProduct[i] = right;
            right *= nums[i];
        }
        
        int[] result = new int[nums.length];
        for (int i =  0; i < nums.length; i++) {
            result[i] = leftProduct[i] * rightProduct[i];
        }
        
        return result;
    }
}

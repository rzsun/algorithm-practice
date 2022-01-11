class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int num = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            
            while (start < end) {
                if (start != i + 1 && nums[start] == nums[start - 1]) {
                    start++;
                    continue;
                }
                if (end != nums.length - 1 && nums[end] == nums[end + 1]) {
                    end--;
                    continue;
                }
                
                int twoSum = nums[start] + nums[end];
                
                if (twoSum + num == 0) {
                    result.add(List.of(num, nums[start], nums[end]));
                    start++;
                    end--;
                } else if (twoSum + num < 0) {
                    start++;
                } else if (twoSum + num > 0) {
                    end--;
                }
                
            }
            
        }
        
        return result;
    }
}

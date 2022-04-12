class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums, 0, false, new ArrayList<>(), result);
        return result;
    }
    
    public void subsets(int[] nums, 
                        int start, 
                        boolean chosenPrev,
                        List<Integer> current,
                        List<List<Integer>> result) {
        if (start == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        subsets(nums, start + 1, false, current, result);
        if (start > 0 && nums[start] == nums[start - 1] && !chosenPrev) {
            return;
        }
        int val = nums[start];
        current.add(val);
        subsets(nums, start + 1, true, current, result);
        current.remove(current.size() - 1);
    }
}

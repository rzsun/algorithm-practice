class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        recurse(subsets, new ArrayList<>(), nums,0);
        return subsets;
    }
    
    public void recurse(List<List<Integer>> subsets, 
                        List<Integer> current, 
                        int[] nums, 
                        int start) {
        if (start >= nums.length) {
            subsets.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[start]);
        recurse(subsets, current, nums, start + 1);
        current.remove(current.size() - 1);
        recurse(subsets, current, nums, start + 1);
    }
}

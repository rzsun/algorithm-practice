class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        recurse(subsets, nums, 0);
        return subsets;
    }
    
    public void recurse(List<List<Integer>> subsets, int[] nums, int start) {
        if (start >= nums.length) {
            return;
        }
        List<List<Integer>> newSubsets = new ArrayList<>();
        for (List<Integer> l : subsets) {
            List<Integer> l2 = new ArrayList<>(l);
            l2.add(nums[start]);
            newSubsets.add(l2);
        }
        subsets.addAll(newSubsets);
        recurse(subsets, nums, start+1);
    }
}

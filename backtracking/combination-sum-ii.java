class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        recurse(candidates, 0, target, new ArrayList<>(), results);
        return results;
    }
    
    public void recurse(int[] nums,
                        int start,
                        int target, 
                        List<Integer> combo,
                        List<List<Integer>> results) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            results.add(new ArrayList<>(combo));
        }
        
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            combo.add(nums[i]);
            recurse(nums, i + 1, target - nums[i], combo, results);
            combo.remove(combo.size() - 1);
        }
    }
}

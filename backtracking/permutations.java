class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(nums, new HashSet<>(), new ArrayList<>(), results);
        return results;
    }
    
    public void backtrack(int[] nums,
                          Set<Integer> used, 
                          List<Integer> current, 
                          List<List<Integer>> results) {
        
        if (used.size() == nums.length) {
            results.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used.contains(i)) {
                continue;
            }
            int val = nums[i];
            used.add(i);
            current.add(val);
            backtrack(nums, used, current, results);
            current.remove(current.size() - 1);
            used.remove(i);
        }
    }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        recurse(candidates, 0, target, new ArrayList<>(), results);
        return results;
    }
    
    
    public void recurse(int[] candidates,
                        int start,
                        int target, 
                        List<Integer> combo, 
                        List<List<Integer>> results) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            results.add(combo);
        }
        
        for (int i = start; i < candidates.length; i++) {
            List<Integer> copy = new ArrayList<>(combo);
            copy.add(candidates[i]);
            recurse(candidates, i, target - candidates[i], copy, results);
        }
    }
}

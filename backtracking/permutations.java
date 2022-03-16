class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(new HashSet<>(
            Arrays.stream(nums).boxed()
            .collect(Collectors.toSet())), 
                  new ArrayList<>(), results);
        return results;
    }
    
    public void backtrack(
        Set<Integer> remaining, 
        List<Integer> current, 
        List<List<Integer>> results) {
        
        if (remaining.isEmpty()) {
            results.add(current);
            return;
        }
        
        for (Integer val : remaining) {
            List<Integer> newCurrent = new ArrayList<>(current);
            Set<Integer> newRemaining = new HashSet<>(remaining);
            
            newCurrent.add(val);
            newRemaining.remove(val);
            backtrack(newRemaining, newCurrent, results);
        }
        
    }
}

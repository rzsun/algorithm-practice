public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Map<Integer, Integer>> ways = new HashMap<>();
        return findTargetWayRecursive(nums, 0, target, ways);
    }
    
    public int findTargetWayRecursive(int[] nums, int start, int target, Map<Integer, Map<Integer, Integer>> ways) {
        
        if (ways.containsKey(start)) {
            if (ways.get(start).containsKey(target)) {
                return ways.get(start).get(target);
            }
        } else {
            ways.put(start, new HashMap<>());
        }
        
        if (start >= nums.length) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        
        int result = findTargetWayRecursive(nums, start + 1, target + nums[start], ways) +
            findTargetWayRecursive(nums, start + 1, target - nums[start], ways);
        ways.get(start).put(target, result);
        return result;
    }

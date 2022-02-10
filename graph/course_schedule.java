class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> preToPosts = new HashMap<>();
        Map<Integer, Integer> postPreCounts = new HashMap<>();
        
        for (int i = 0; i < prerequisites.length; i++) {
            
            int pre = prerequisites[i][0];
            int post = prerequisites[i][1];

            if (pre == post) {
                return false;
            }

            if (!preToPosts.containsKey(pre)) {
                preToPosts.put(pre, new HashSet<Integer>());
            }
            preToPosts.get(pre).add(post);
            postPreCounts.put(post, postPreCounts.getOrDefault(post, 0) + 1);
            postPreCounts.put(pre, postPreCounts.getOrDefault(pre, 0));
        }
        
        Deque<Integer> noPreCourses = new ArrayDeque<>();
        for (Map.Entry<Integer, Integer> postPreCount : postPreCounts.entrySet()) {
            if (postPreCount.getValue() == 0) {
                noPreCourses.addLast(postPreCount.getKey());
            }
        }

        int seenCourses = 0;
        while (!noPreCourses.isEmpty()) {
            Integer current = noPreCourses.pollFirst();
            seenCourses++;

            if (preToPosts.containsKey(current)) {
                for (Integer pre : preToPosts.get(current)) {
                    postPreCounts.put(pre, postPreCounts.get(pre) - 1);
                    if (postPreCounts.get(pre) == 0) {
                        noPreCourses.addLast(pre);
                    }
                }
            }
        }
        return seenCourses == numCourses;
    }
}

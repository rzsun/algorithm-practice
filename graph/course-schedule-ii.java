class Solution {
    public int[] findOrder(int numCourses, int[][] prereqs) {
        
        int[] numPre = new int[numCourses];
        Arrays.fill(numPre, 0);
        
        Map<Integer, Set<Integer>> preToPost = new HashMap<>();
        for (int i = 0; i < prereqs.length; i++) {
            int pre = prereqs[i][1];
            int post = prereqs[i][0];
            numPre[post]++;
            if (!preToPost.containsKey(pre)) {
                preToPost.put(pre, new HashSet<>());
            }
            preToPost.get(pre).add(post);
        }
        
        int count = 0;
        int[] result = new int[numCourses];
        
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (numPre[i] == 0) {
                stack.add(i);
                result[count] = i;
                count++;
            }
        }
        
        while (!stack.isEmpty()) {
            int pre = stack.poll();
            if (preToPost.containsKey(pre)) {
                for (Integer post : preToPost.get(pre)) {
                    numPre[post]--;
                    if (numPre[post] == 0) {
                        result[count] = post;
                        count++;
                        stack.addFirst(post);
                    }
                }
            }
        }
        if (count == numCourses) {
            return result;
        }
        return new int[0];
    }
}

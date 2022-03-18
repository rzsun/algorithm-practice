class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        if (triangle.size() == 0) {
            return 0;
        }
        
        Map<Integer, Map<Integer, Integer>> minPath = new HashMap<>();
        minPath.put(0, new HashMap<>());
        minPath.get(0).put(0, triangle.get(0).get(0));
        
        int min = triangle.get(0).get(0);
        
        for (int i = 1; i < triangle.size(); i++) {
            int curMin;
            
            minPath.put(i, new HashMap<>());
            
            int curPath = minPath.get(i - 1).get(0) + triangle.get(i).get(0);
            minPath.get(i).put(0, curPath);
            
            curMin = curPath;
            
            for (int j = 1; j < triangle.get(i).size() - 1; j++) {
                int currentMin = Math.min(
                    minPath.get(i - 1).get(j),
                    minPath.get(i - 1).get(j - 1)
                );
                curPath = currentMin + triangle.get(i).get(j);
                minPath.get(i).put(j, curPath);
            
                curMin = Math.min(curPath, curMin);
            }
            
            
            curPath = minPath.get(i - 1).get(triangle.get(i - 1).size() - 1) + 
                triangle.get(i).get(triangle.get(i).size() - 1);
            
            minPath.get(i).put(triangle.get(i).size() - 1, curPath);
            curMin = Math.min(curPath, curMin);
            
            min = curMin;
        }
        
        return min;
        
    }
}

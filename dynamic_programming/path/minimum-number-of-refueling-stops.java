class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        Map<Integer, Integer> refuels = new HashMap<>();
        
        refuels.put(0, startFuel);
        
        
        for (int i = 0; i < stations.length; i++) {
            int curMax = refuels.keySet().size();
            for (int j = curMax; j > 0; j--) {
                int fuel = stations[i][1];
                int position = stations[i][0];
                
                if (position <= refuels.get(j - 1)) {
                    if (!refuels.containsKey(j)) {
                        refuels.put(j, refuels.get(j - 1) + fuel);
                    } else {
                        refuels.put(j, 
                                    Math.max(refuels.get(j),
                                             refuels.get(j - 1) + fuel));
                    }
                }
            }
        }
        
        for (int i = 0; i < refuels.keySet().size(); i++) {
            if (refuels.get(i) >= target) {
                return i;
            }
        }
        return -1;
        
    }
}

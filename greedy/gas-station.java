class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int start = 0;
        int totalSurplus = 0; // total difference between cost and gas
        int tank = 0;
        
        for (int i = 0; i < gas.length; i++) {
            
            int surplus = gas[i] - cost[i];
            totalSurplus += surplus;
            tank += surplus;
            
            if (tank <  0) { // if tank goes negative, start trip at next stop
                start = i + 1;
                tank = 0;
            }
        }
        
        if (totalSurplus < 0) {
            return -1;
        }
        return start;
    }
}

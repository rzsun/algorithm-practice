class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        int lastDay = days[days.length - 1];
        
        int dayCost[] = new int[lastDay + 1]; // up to day
        dayCost[0] = 0;
        
        Set<Integer> allDays = new HashSet<>();
        for (int i = 0; i < days.length; i++) {
            allDays.add(days[i]);
        }
        
        for (int i = 1; i <= lastDay; ++i) {
            
            if (!allDays.contains(i)) {
                dayCost[i] = dayCost[i - 1];
                continue;
            }
            
            dayCost[i] = dayCost[i - 1] + costs[0];
            
            if (i < 7) {
                dayCost[i] = Math.min(dayCost[i], costs[1]);
            } else {
                dayCost[i] = Math.min(dayCost[i], dayCost[i - 7] + costs[1]);
            }
            
            if (i < 30) {
                dayCost[i] = Math.min(dayCost[i], costs[2]);
            } else {
                dayCost[i] = Math.min(dayCost[i], dayCost[i - 30] + costs[2]);
            }
        }
        
        return dayCost[lastDay];
    }
}
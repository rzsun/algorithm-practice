class Solution {
    public int climbStairs(int n) {
        
        List<Integer> ways = new ArrayList<>();
        ways.add(1);
        ways.add(1);
        
        for (int i = 2; i <= n; i++) {
            ways.add(ways.get(i-1) + ways.get(i-2));
        }
        
        return ways.get(n);
    }
}

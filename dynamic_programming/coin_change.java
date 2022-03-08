class Solution {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> combinations = new HashMap<>();
        
        combinations.put(0, 0);
        
        for (int i = 1; i <= amount; i++) {
            int combination = -1;
            for (int coin : coins) {
                if (!combinations.containsKey(i - coin)) {
                    continue;
                }
                if (combinations.get(i - coin) == -1) {
                    continue;
                }
                if (combination == -1) {
                    combination = combinations.get(i - coin) + 1;
                } else {
                    combination = Math.min(combination, combinations.get(i - coin) + 1);
                }
            }
            combinations.put(i, combination);
        }
        
        return combinations.get(amount);
    }
}

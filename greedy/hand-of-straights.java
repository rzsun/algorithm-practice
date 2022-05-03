class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        
        while (!map.isEmpty()) {
            int start = map.firstKey();
            decrement(start, map);
            for (int card = start + 1; card < start+groupSize; card++) {
                if (!map.containsKey(card)) {
                    return false;
                }
                decrement(card, map);
            }
        }
        return true;
    }
    
    public void decrement(int card, Map<Integer, Integer> map) {
        int val = map.get(card) - 1;
        if (val == 0) {
            map.remove(card);
        } else {
            map.put(card, val);
        }
    }
}

class Solution {
    // k = sum - prefix
    // prefix = sum - k
    public int subarraySum(int[] nums, int k) {
        // Map to store how many times prefix occurs
        // e.g. 0 1 2 -1 1
        // prefix of 3 should include [0 1 2] [1 2] [1 2 -1 1]
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (prefix.containsKey(sum - k)) {
                result += prefix.get(sum - k);
            }
            prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}

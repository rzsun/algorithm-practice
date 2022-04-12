class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> valid = new ArrayList<>();
        int max = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) {
                valid.add(i);
            }
            max = Math.max(max, heights[i]);
        }
        Collections.reverse(valid);
        return valid.stream().mapToInt(Integer::intValue).toArray();
    }
}

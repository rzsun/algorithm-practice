class Solution {
    public static int uniquePaths(int m, int n) {

        int[][] uniqueWays = new int[m][n];
        if (m == 0 && n == 0) {
            return 0;
        }
        uniqueWays[0][0] = 1;

        Deque<int[]> pos = new ArrayDeque<>();
        pos.addLast(new int[]{1, 0});
        pos.addLast(new int[]{0, 1});

        while (!pos.isEmpty()) {
            int[] cur = pos.removeFirst();
            int x = cur[0];
            int y = cur[1];
            if (x >= m || y >= n || uniqueWays[x][y] != 0) {
                continue;
            }

            int ways = 0;
            if (x - 1 >= 0) {
                ways += uniqueWays[x - 1][y];
            }
            if (y - 1 >= 0) {
                ways += uniqueWays[x][y - 1];
            }
            uniqueWays[x][y] = ways;

            if (x + 1 < m) {
                pos.addLast(new int[]{x + 1, y});
            };
            if (y + 1 < n) {
                pos.addLast(new int[]{x, y + 1});
            };
        }
        return uniqueWays[m-1][n-1];
    }
}

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    int[][] DIRS = new int[][] {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public int largestIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] ids = new int[row][col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                ids[r][c] = -1;
            }
        }

        Map<Integer, Integer> sizes = new HashMap<>();

        int idCounter = 0;
        int max = 0;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (ids[r][c] != 0 && grid[r][c] == 1) {
                    int size = dfs(grid, ids, r, c, idCounter);
                    sizes.put(idCounter, size);
                    idCounter++;
                    max = Math.max(size, max);
                }
            }
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 0) {
                    int size = 1;
                    Set<Integer> seen = new HashSet<>();
                    for (int[] dir : DIRS) {
                        int r1 = r + dir[0];
                        int c1 = c + dir[1];
                        if (!withinBounds(grid, r1, c1)) {
                            continue;
                        }
                        int id = ids[r1][c1];
                        if (id != -1 && !seen.contains(id)) {
                            size += sizes.get(id);
                            seen.add(id);
                        }
                    }
                    max = Math.max(size, max);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int[][] ids, int r, int c, int id) {
        if (!withinBounds(grid, r, c)) {
            return 0;
        }

        if (ids[r][c] != -1) {
            return 0;
        }

        if (grid[r][c] == 0) {
            return 0 ;
        }

        ids[r][c] = id;
        int size = 1;
        for (int[] dir : DIRS) {
            size += dfs(grid, ids, r + dir[0], c + dir[1], id);
        }
        return size;
    }

    public static boolean withinBounds(int[][] grid, int r, int c) {
        return r < grid.length && r >= 0 && c < grid[0].length && c >= 0;
    }
}

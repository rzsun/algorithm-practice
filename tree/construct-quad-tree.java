/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return recurse(grid, 0, 0, grid.length);
    }
    
    
    public Node recurse(int[][] grid, int rowStart, int colStart, int size) {
        int val = grid[rowStart][colStart];
        boolean valBool = grid[rowStart][colStart] == 1;
        boolean isLeaf = true;
        
        for (int row = rowStart; row < rowStart + size; row++) {
            for (int col = colStart; col < colStart + size; col++) {
                if (grid[row][col] != val) {
                    isLeaf = false;
                    break;
                }
            }
        }
        if (isLeaf) {
            return new Node(valBool, isLeaf);
        }
        return new Node(valBool, isLeaf,
                        recurse(grid, rowStart, colStart, size/2),
                        recurse(grid, rowStart, colStart+size/2, size/2),
                        recurse(grid, rowStart+size/2, colStart, size/2),
                        recurse(grid, rowStart+size/2, colStart+size/2, size/2));
    }
    
    
}

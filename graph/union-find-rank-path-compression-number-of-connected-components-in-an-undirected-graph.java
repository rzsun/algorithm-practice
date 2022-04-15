class Solution {
    public int countComponents(int n, int[][] edges) {
        
        int[] rank = new int[n];
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = 1;
            parents[i] = i;
        }
        
        int count = n;
        for (int i = 0; i < edges.length; i++) {
            if (union(edges[i][0], edges[i][1], rank, parents)) {
                count--;
            }
        }
        return count;
    }
    
    
    public boolean union(int a, int b, int[] rank, int[] parents) {
        int aRoot = find(a, parents);
        int bRoot = find(b, parents);
        
        if (aRoot == bRoot) {
            return false;
        }
        
        if (rank[aRoot] > rank[bRoot]) {
            parents[bRoot] = aRoot;
            rank[aRoot] += rank[bRoot];
        } else {
            parents[aRoot] = bRoot;
            rank[bRoot] += rank[aRoot];
        }
        return true;
    }
    
    public int find(int n, int[] parents) {
        while (n != parents[n]) {
            parents[n] = parents[parents[n]]; // path compression
            n = parents[n];
        }
        return n;
    }
    
}

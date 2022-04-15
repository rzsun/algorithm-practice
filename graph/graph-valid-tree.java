class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] rank = new int[n];
        int[] parents = new int[n];
        
        for (int i = 0; i < n; i++) {
            rank[i] = 1;
            parents[i] = i;
        }
        
        int count = n;
        for (int i = 0; i < edges.length; i++) {
            if (!union(edges[i][0], edges[i][1], rank, parents)) {
                return false;
            } else {
                count--;
            }
        }
        return count == 1;
    }
    
    public int find(int n, int[] parents) {
        while (n != parents[n]) {
            parents[n] = parents[parents[n]];
            n = parents[n];
        }
        return n;
    }
    
    public boolean union(int a, int b, int[] rank, int[] parents) {
        int rootA = find(a, parents);
        int rootB = find(b, parents);
        
        if (rootA == rootB) {
            return false;
        }
        
        if (rank[rootA] > rank[rootB]) {
            parents[rootB] = rootA;
            rank[rootA] += rank[rootB];
        } else {
            parents[rootA] = rootB;
            rank[rootB] += rank[rootA];
        }
        return true;
    }
}

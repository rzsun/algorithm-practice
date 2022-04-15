class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int max = 0;
        for (int i = 0; i < edges.length; i++) {
            max = Math.max(max, Math.max(edges[i][0], edges[i][1]));
        }
        
        int[] parents = new int[max + 1];
        int[] rank = new int[max + 1];
        for (int i = 0; i < max; i++) {
            parents[i] = i;
            rank[i] = 1;
        }
        
        for (int i = 0; i < edges.length; i++) {
            if (!union(edges[i][0], edges[i][1], parents, rank)) {
                return edges[i];
            }
        }
        return null;
    }
    
    public boolean union(int a, int b, int[] parents, int[] rank) {
        int aGroup = find(parents, a);
        int bGroup = find(parents, b);

        if (aGroup == bGroup) {
            return false;
        }

        if (rank[aGroup] > rank[bGroup]) {
            parents[bGroup] = aGroup;
            rank[aGroup] += rank[bGroup];
        } else {
            parents[aGroup] = bGroup;
            rank[bGroup] += rank[aGroup];
        }
        return true;
    }
    
    public int find(int[] parents, int n) {
        while (n != parents[n]) {
            parents[n] = parents[parents[n]]; // path compression
            n = parents[n];
        }
        return n;
    }
}

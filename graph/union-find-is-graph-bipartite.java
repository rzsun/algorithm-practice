class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int[] rank = new int[graph.length];
        int[] group = new int[graph.length];
        for (int u = 0; u < graph.length; u++) {
            group[u] = u;
        }
        
        for (int u = 0; u < graph.length; u++) {
            for (int v = 0; v < graph[u].length; v++) {
                if (find(u, group) == find(graph[u][v], group)) {
                    return false;
                }
                union(graph[u][0], graph[u][v], rank, group);
            }
        }
        return true;
    }
    
    public boolean union(int u, int v, int[] rank, int group[]) {
        int groupU = find(u, group);
        int groupV = find(v, group);
        
        if (groupV == groupU) {
            return false;
        }
        
        if (rank[u] > rank[v]) {
            group[groupU] = groupV;
            rank[groupU] += rank[groupV];
        } else {
            group[groupV] = groupU;
            rank[groupV] += rank[groupU];
        }
        return true;
    }
    
    public int find(int n, int[] group) {
        while (n != group[n]) {
            group[n] = group[group[n]];
            n = group[n];
        }
        return n;
    }
}

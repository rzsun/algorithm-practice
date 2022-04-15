class Solution {
    
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adj = constructAdjList(tickets);
        List<String> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        current.add("JFK");
        backtrack("JFK", adj, current, result, tickets.size());
        return result;
    }
    
    public boolean backtrack(String airport, 
                              Map<String, List<String>> adj,
                              List<String> current,
                              List<String> result,
                              int numTickets) {
        if (current.size() == numTickets + 1) {
            result.addAll(current);
            return true;
        }
        
        List<String> nexts = adj.get(airport);
        if (nexts == null || nexts.size() == 0) {
            return false;
        }
        Collections.sort(nexts, (a,b) -> b.compareTo(a));
        
        for (int i = nexts.size() - 1; i >= 0; i--) {
            String next = nexts.get(i);
            nexts.remove(i);
            current.add(next);
            if (backtrack(next, adj, current, result, numTickets)) {
                return true;
            }
            current.remove(current.size() - 1);
            nexts.add(next);
        }
        return false;
    }
    
    public Map<String, List<String>> constructAdjList(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            String source = ticket.get(0);
            String destination = ticket.get(1);
            if (!adj.containsKey(source)) {
                adj.put(source, new ArrayList<>());
            }
            adj.get(source).add(destination);
        }
        return adj;
    }
}

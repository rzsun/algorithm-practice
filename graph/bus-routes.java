class Solution {
    
    class BusRoute {
        int id;
        Set<Integer> route;
        BusRoute(int id, int[] route) {
            this.id = id;
            this.route = new HashSet<>();
            for (int stop : route) {
                this.route.add(stop);
            }
        }
    }
    
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        
        Map<Integer, Set<BusRoute>> stopsToRoutes = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            BusRoute busRoute = new BusRoute(i, routes[i]);
            for (int stop : routes[i]) {
                if (!stopsToRoutes.containsKey(stop)) {
                    stopsToRoutes.put(stop, new HashSet<>());
                }
                stopsToRoutes.get(stop).add(busRoute);
            }
        }
        
        Set<Integer> explored = new HashSet<>();
        Deque<BusRoute> queue = new ArrayDeque<>();
        for (BusRoute busRoute : stopsToRoutes.get(source)) {
            explored.add(busRoute.id);
            queue.addLast(busRoute);
        }
        
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BusRoute current = queue.pollFirst();
                if (current.route.contains(target)) {
                    return count;
                }
                for (Integer stop : current.route) {
                    for (BusRoute transfer : stopsToRoutes.get(stop)) {
                        if (explored.contains(transfer.id)) {
                            continue;
                        }
                        explored.add(transfer.id);
                        queue.addLast(transfer);
                    }
                    
                }
            }
            count++;
        }
        return -1;
    }
}

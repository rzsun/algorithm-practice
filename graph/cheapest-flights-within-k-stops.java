class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> flightPrices = new HashMap<>(); // src -> [dst, price]
        for (int[] flight : flights) {
            int source = flight[0];
            int destination = flight[1];
            int price = flight[2];
            
            if (!flightPrices.containsKey(source)) {
                flightPrices.put(source, new ArrayList<>());
            }
            flightPrices.get(source).add(new int[]{destination, price});
        }
        
        // [current city, current price, current flights]
        PriorityQueue<int[]> frontier = new PriorityQueue<>((a,b)->a[1] - b[1]);
        frontier.offer(new int[]{src, 0, 0});
        Map<Integer, Integer> explored = new HashMap<>();
        
        while (!frontier.isEmpty()) {
            int[] current = frontier.poll();
            int currentCity = current[0];
            int currentPrice = current[1];
            int currentFlights = current[2];
            
            if (currentCity == dst) {
                return currentPrice;
            }
            
            if (currentFlights >= k + 1) {
                continue;
            }
            
            if (explored.containsKey(currentCity) && 
                explored.get(currentCity) < currentFlights) {
                continue;
            }
            explored.put(currentCity, currentFlights);
            
            if (!flightPrices.containsKey(currentCity)) {
                continue;
            }
            
            for (int[] next : flightPrices.get(currentCity)) {
                int nextCity = next[0];
                int nextPrice = currentPrice + next[1];
                frontier.offer(new int[]{nextCity, nextPrice, currentFlights + 1});
            }
        }
        
        return -1;
    }
}

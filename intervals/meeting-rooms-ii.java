class Solution {
    /*
    Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
    */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        
        // sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // priority queue sorted by end time
        PriorityQueue<int[]> rooms = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        for (int i = 0; i < intervals.length; i++) {
            int[] current = rooms.poll(); // earliest ending meeting
            if (current == null) {
                rooms.offer(intervals[i]);
                continue;
            }
            // if next meeting starts after current ends, join them in same room
            if (current[1] <= intervals[i][0]) {
                current[1] = intervals[i][1];
                rooms.offer(current);
                
            // else they need different rooms
            } else {
                rooms.offer(current);
                rooms.offer(intervals[i]);
            }
        }
        return rooms.size();
    }
}

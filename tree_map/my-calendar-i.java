class MyCalendar {
    
    TreeMap<Integer, Integer> cal;

    public MyCalendar() {
        cal = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer low = cal.lowerKey(end);
        if (low == null || cal.get(low) <= start) {
            cal.put(start, end);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

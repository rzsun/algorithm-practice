class Logger {
    
    Map<String, Integer> lastPrinted = new HashMap<>();

    public Logger() {
        
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!lastPrinted.containsKey(message) || 
           timestamp - lastPrinted.get(message) >= 10) {
            lastPrinted.put(message, timestamp);
            return true;
        }
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */

class TimeMap {
    private class Data {
        String value;
        int timestamp;
        Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private final HashMap<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Data> vals = map.get(key);

        int low = 0;
        int high = vals.size() - 1;
        while(low < high) {
            int mid = (high + low + 1)/2;
            if (vals.get(mid).timestamp <= timestamp) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        if (vals.get(low).timestamp <= timestamp) {
            return vals.get(low).value;
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

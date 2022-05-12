class Solution {
    public String addBoldTag(String s, String[] words) {
        
        // all start and end occurances of words
        List<int[]> intervals = new ArrayList<>();
        for (String word : words) {
            int start = s.indexOf(word);
            while (start != -1) {
                intervals.add(new int[]{start, start+word.length()});
                start = s.indexOf(word, start+1);
            }
        }
        if (intervals.size() == 0) {
            return s;
        }
        Collections.sort(intervals, (a,b) -> a[0] - b[0]);
        
        List<int[]> merged = new ArrayList<>();
        int[] first = intervals.get(0);
        int start = first[0];
        int end = first[1];
        for (int i = 1; i < intervals.size(); i++) {
            int[] cur = intervals.get(i);
            if (cur[0] > end) {
                merged.add(new int[]{start, end});
                start = cur[0];
            }
            end = Math.max(end, cur[1]);
        }
        merged.add(new int[]{start, end});
        
        StringBuilder result = new StringBuilder();
        start = 0;
        for (int[] interval : merged) {
            if (interval[0] - start > 0) {
                result.append(s.substring(start, interval[0]));
            }
            result.append("<b>");
            result.append(s.substring(interval[0], interval[1]));
            result.append("</b>");
            start = interval[1];
        }
        if (start < s.length()) {
            result.append(s.substring(start, s.length()));
        }
        return result.toString();
    }
}

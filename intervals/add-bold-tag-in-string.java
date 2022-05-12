class Solution {
    public String addBoldTag(String s, String[] words) {
        // start, length
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (String word : words) {
                int start = s.indexOf(word, i);
                if (start != -1) {
                    intervals.add(new int[]{start, start+word.length()});
                }
            }
        }
        Collections.sort(intervals, (a,b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        Iterator<int[]> it = intervals.iterator();
        if (it.hasNext()) {
            int[] first = it.next();
            int start = first[0];
            int end = first[1];
            while (it.hasNext()) {
            int[] cur = it.next();
            if (cur[0] > end) {
                    merged.add(new int[]{start, end});
                    start = cur[0];
                }
                end = Math.max(end, cur[1]);
            }
            merged.add(new int[]{start, end});
        }

        StringBuilder result = new StringBuilder();
        int start = 0;

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

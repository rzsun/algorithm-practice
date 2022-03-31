class Solution {
    public String decodeString(String s) {
        String result = "";
        Deque<String> part = new ArrayDeque<>();
        Deque<Integer> times = new ArrayDeque<>();
        int i = 0;
        
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count *= 10;
                    count += Integer.parseInt(String.valueOf(s.charAt(i)));
                    i++;
                }
                times.addFirst(count);
            }
            if (s.charAt(i) == '[') {
                part.addFirst(result);
                result = "";
            } else if (s.charAt(i) == ']') {
                String current = part.pollFirst();
                if (current == null) {
                    current = "";
                }
                int repeat = times.pollFirst();
                for (int j = 0; j < repeat; j++) {
                    current += result;
                }
                result = current;
            } else {
                result += s.charAt(i);
            }
            i++;
        }
        return result;
    }
}

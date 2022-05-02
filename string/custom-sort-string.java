class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> pos = new HashMap();
        for (int i = 0; i < order.length(); i++) {
            pos.put(order.charAt(i), i);
        }

        Character[] charArray = s.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        Arrays.sort(charArray, (a, b) -> pos.getOrDefault(a, -1) - pos.getOrDefault(b, -1));
        String result = "";
        for (Character c : charArray) {
            result += c;
        }
        return result;
    }
}

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int pos1 = -1;
        int pos2 = -1;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if (word.equals(word1)) {
                pos1 = i;
            }
            if (word.equals(word2)) {
                pos2 = i;
            }
            if (pos1 != -1 && pos2 != -1) {
                min = Math.min(Math.abs(pos1 - pos2), min);
            }
        }
        return min;
    }
}

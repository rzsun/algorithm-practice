class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int pos1 = -1;
        int pos2 = -1;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < wordsDict.length; i++) {
            String cur = wordsDict[i];
            if (cur.equals(word1) ) {
                if (cur.equals(word2)) {
                    if (pos1 != -1) {
                        min = Math.min(min, i - pos1);
                    }
                } else {
                    if (pos2 != -1) {
                        min = Math.min(min, i - pos2);
                    }
                }
                pos1 = i;
            } else if(cur.equals(word2)) {
                if (pos1 != -1) {
                    min = Math.min(min, i - pos1);
                }
                pos2 = i;
            }
        }
        return min;
    }
}

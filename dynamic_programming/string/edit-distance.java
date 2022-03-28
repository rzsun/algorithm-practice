class Solution {
    public int minDistance(String word1, String word2) {
        
        // edit distance from word1[i-1]. word2[j-1]
        // word1[i]!=word2[j]: distance[i, j] = min(distance[i-1, j-1], distance[i-1,j], distance[i,j-1]) + 1
        // word1[i]==word2[j]: distance[i, j] = distance[i-1, j-1]
        int [][] distance = new int[word1.length() + 1][word2.length() + 1];
        
        
        for (int i = 0; i <= word1.length(); i++) {
            distance[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            distance[0][j] = j;
        }
        
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                int iPos = i-1;
                int jPos = j-1;
                
                distance[i][j] = distance[i-1][j-1];
                if (word1.charAt(iPos) != word2.charAt(jPos)) {
                    distance[i][j] = Math.min(distance[i][j], 
                                            Math.min(distance[i-1][j], distance[i][j-1])) + 1;
                }
            }
        }
        return distance[word1.length()][word2.length()];
    }
}

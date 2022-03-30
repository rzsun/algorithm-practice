class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> lines = convertToLines(words, maxWidth);
                
        List<String> result = new ArrayList<>();
        for (int i = 0; i < lines.size() - 1; i++) {
            result.add(fullJustifyLine(lines.get(i), maxWidth));
        }
        result.add(leftJustify(lines.get(lines.size() - 1), maxWidth));
        return result;
    }
    
    public List<List<String>> convertToLines(String[] words, int maxWidth) {
        List<List<String>> lines = new ArrayList<>();
        lines.add(new ArrayList<>());
        
        int currentLength = 0;
        for (String word : words) {
            if (currentLength + word.length() > maxWidth) {
                lines.add(new ArrayList<>());
                currentLength = 0;
            }
            
            lines.get(lines.size() - 1).add(word);
            currentLength += word.length() + 1;
        }
        return lines;
    }
    
    public String fullJustifyLine(List<String> line, int maxWidth) {
        if (line.size() == 1) {
            return leftJustify(line, maxWidth);
        }
        
        int lineLength = getLineLength(line);
        
        int i = 0;
        while (lineLength < maxWidth) {
            line.set(i, line.get(i).concat(" "));
            lineLength++;
            i++;
            if (i == line.size() - 1) {
                i = 0;
            }
        }
        
        String result = "";
        for (String word : line) {
            result += word;
        }
        return result;
    }
    
    public String leftJustify(List<String> line, int maxWidth) {
        String result = "";
        for (int i = 0; i < line.size() - 1; i++) {
            result += line.get(i) + " ";
        }
        result += line.get(line.size() - 1);
        result += whitespaceString(maxWidth - result.length());
        return result;
    }
    
    public int getLineLength(List<String> line) {
        int lineLength = 0;
        for (String word : line) {
            lineLength += word.length();
        }
        return lineLength;
    }
    
    public String whitespaceString(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += " ";
        }
        return result;
    }
}

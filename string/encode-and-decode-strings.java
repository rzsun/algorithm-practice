public class Codec {
    
    public static final String delimiter = "@";
    public static final String splitter = "/";
    
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String result = "";
        for (String s : strs) {
            s = s.replaceAll(delimiter, delimiter + delimiter);
            result += s.replaceAll(splitter, delimiter + splitter);
            result += splitter;
        }
        return result;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        
        List<String> result = new ArrayList<>();
        String current = "";
        
        for (int i = 0; i < s.length(); i++) {
            boolean canSplit = true;
            if (s.charAt(i) == delimiter.charAt(0)) {
                i++;
                if (i >= s.length()) {
                    break;
                }
                canSplit = false;
            }
            if (s.charAt(i) == splitter.charAt(0) && canSplit) {
                result.add(current);
                current = "";
                continue;
            }
            current += s.charAt(i);
        }
        if (!current.equals("")) {
            result.add(current);
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));

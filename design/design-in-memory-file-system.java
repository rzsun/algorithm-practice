class FileSystem {
    static final String DELIMITER = "/";

    class File {
        boolean isDir;
        StringBuilder content;
        Map<String, File> children;
        
        File(boolean isDir) {
            this.isDir = isDir;
            if (isDir) {
                children = new TreeMap<>();
            } else {
                content = new StringBuilder();
            }
        }
        
        void append(String s) {
            this.content.append(s);
        }
    }

    File root;

    public FileSystem() {
        root = new File(true);
    }

    public List<String> ls(String path) {
        String[] parts = parseParts(path);
        List<String> output = new ArrayList<>();

        File f = getFile(parts);
        if (f.isDir) {
            output.addAll(f.children.keySet());
        } else {
            String fileName = parts[parts.length - 1];
            output.add(fileName);
        }
        return output;
    }

    public void mkdir(String path) {
        getFile(parseParts(path));
    }

    public void addContentToFile(String filePath, String content) {
        String[] parts = parseParts(filePath);
        File dir = getFile(Arrays.copyOfRange(parts, 0, parts.length-1));
        String fileName = parts[parts.length-1];
        if (!dir.children.containsKey(fileName)) {
            dir.children.put(fileName, new File(false));
        }
        dir.children.get(fileName).append(content);
    }

    public String readContentFromFile(String filePath) {
        return getFile(parseParts(filePath)).content.toString();
    }
    
    private String[] parseParts(String path) {
        return path.split(DELIMITER);
    }

    // gets dir or creates if not exist
    private File getFile(String[] parts) {
        File dir = root;
        for (String part : parts) {
            if ("".equals(part)) {
                continue;
            }
            if (!dir.children.containsKey(part)) {
                File newDir = new File(true);
                dir.children.put(part, newDir);
            }
            dir = dir.children.get(part);
        }
        return dir;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */

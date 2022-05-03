class FileSystem {
    
    class File {
        boolean isDir;
        String content;
        Map<String, File> children;
        File(boolean isDir) {
            this.isDir = isDir;
            if (isDir) {
                children = new TreeMap<>();
            }
        }
        File(String content) {
            this(false);
            this.content = content;
        }
    }
    
    File root;

    public FileSystem() {
        root = new File(true);
    }
    
    public List<String> ls(String path) {
        String[] parts = path.split("/");
        File f = getFile(parts);
        List<String> output = new ArrayList<>();
        if (f.isDir) {
            output.addAll(f.children.keySet());
        } else {
            output.add(parts[parts.length - 1]);
        }
        return output;
    }
    
    public void mkdir(String path) {
        String[] parts = path.split("/");
        getFile(parts);
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] parts = filePath.split("/");
        File dir = getFile(
            Arrays.copyOfRange(parts, 0, parts.length-1));

        String fileName = parts[parts.length-1];
        if (!dir.children.containsKey(fileName)) {
            dir.children.put(fileName, new File(""));
        }
        File f = dir.children.get(fileName);
        f.content += content;
    }
    
    public String readContentFromFile(String filePath) {
        String[] parts = filePath.split("/");
        return getFile(parts).content;
    }
    
    // gets Directory or creates if not exist
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

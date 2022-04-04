class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Deque<String> queue = new ArrayDeque<>();
        for (String part : path.split("/")) {
            part = part.replace("/", "");
            if (part.equals("..")) {
                if (!queue.isEmpty()) {
                    queue.removeLast();
                }
            } else if (!part.equals(".") && !part.equals("")) {
                queue.addLast(part);
            }
        }
        
        String result = "";
        while (!queue.isEmpty()) {
            result += "/";
            result += queue.pollFirst();
        }
        if (result.equals("")) {
            result = "/";
        }
        return result;
    }
}

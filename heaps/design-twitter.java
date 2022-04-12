class Twitter {
    
    public static int currentTimestamp = 0;
    
    public static class Tweet {
        public int id;
        public int timestamp;
        public Tweet next;
        
        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }
    
    public static class User {
        public Set<Integer> follows;
        public Tweet head = null;
        
        public User(int id) {
            follows = new HashSet<>();
            follows.add(id);
        }
        
        public void post(int id) {
            Tweet tweet = new Tweet(id, currentTimestamp++);
            tweet.next = head;
            head = tweet;
        }
    }
    
    public Map<Integer, User> users;

    public Twitter() {
        users = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId));
        }
        users.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId));
        }
        
        PriorityQueue<Tweet> heap = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);
        for (int followedId : users.get(userId).follows) {
            if (!users.containsKey(followedId)) {
                continue;
            }
            Tweet tweet = users.get(followedId).head;
            if (tweet != null) {
                heap.offer(tweet);
            }
        }
        
        List<Integer> results = new ArrayList<>();
        while (!heap.isEmpty() && results.size() < 10) {
            Tweet tweet = heap.poll();
            results.add(tweet.id);
            if (tweet.next != null) {
                heap.offer(tweet.next);
            }
        }
        return results;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            users.put(followerId, new User(followerId));
        }
        users.get(followerId).follows.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        users.get(followerId).follows.remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

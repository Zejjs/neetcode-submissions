public class Twitter {

    private final HashMap<Integer, Deque<Tweet>> userTweets;
    private final HashMap<Integer, Set<Integer>> userFollows;
    private int timeStamp = 0;

    public Twitter() {
        userTweets = new HashMap<>();
        userFollows = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userTweets.computeIfAbsent(userId, k -> new ArrayDeque<>())
                .push(new Tweet(tweetId, timeStamp));
        timeStamp++;
    }

    public List<Integer> getNewsFeed(int userId) {
        class TweetPtr {
            final int userId;
            final Iterator<Tweet> it;
            Tweet current;

            TweetPtr(int userId, Iterator<Tweet> it, Tweet current) {
                this.userId = userId;
                this.it = it;
                this.current = current;
            }
        }

        Set<Integer> sources = new HashSet<>();
        if (userTweets.containsKey(userId)) {
            sources.add(userId);
        }
        if (userFollows.containsKey(userId)) {
            sources.addAll(userFollows.get(userId));
        }
        if (sources.isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        PriorityQueue<TweetPtr> pq = new PriorityQueue<>(
                Comparator.comparingInt((TweetPtr t) -> t.current.timeStamp).reversed()
        );

        for (int source : sources) {
            Deque<Tweet> dq = userTweets.get(source);
            if (!dq.isEmpty()) {
                Iterator<Tweet> it = dq.iterator();
                TweetPtr ptr = new TweetPtr(source, it, it.next());
                pq.add(ptr);
            }
        }

        while (!pq.isEmpty() && result.size() < 10) {
            TweetPtr ptr = pq.remove();
            result.add(ptr.current.tweetId);
            if (ptr.it.hasNext()) {
                ptr.current = ptr.it.next();
                pq.add(ptr);
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        userFollows.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        userFollows.computeIfAbsent(followerId, k -> new HashSet<>()).remove(followeeId);
    }

    private static class Tweet {
        int tweetId;
        int timeStamp;

        public Tweet(int tweetId, int timeStamp) {
            this.tweetId = tweetId;
            this.timeStamp = timeStamp;
        }
    }
}

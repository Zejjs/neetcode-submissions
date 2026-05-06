class Twitter {
    object Instant {
        private var time = 0
        fun now(): Int {
            return time++
        }
    }

    private val userTweets: MutableMap<Int, ArrayDeque<Tweet>> = mutableMapOf()
    private val userFollows: MutableMap<Int, MutableSet<Int>> = mutableMapOf()

    fun postTweet(userId: Int, tweetId: Int) {
        val newTweet = Tweet(tweetId, Instant.now())
        userTweets
            .getOrPut(userId) { ArrayDeque<Tweet>() }
            .addFirst(newTweet)
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val sources = mutableSetOf(userId)

        userFollows.get(userId)?.forEach {
            sources.add(it)
        }

        val pq = PriorityQueue<TweetPointer>(
            compareByDescending { it.currentTweet.createdAt }
        )

        for (source in sources) {
            val itr = userTweets.get(source)?.iterator() ?: continue
            val ptr = TweetPointer(
                currentTweet = itr.next(),
                iterator = itr
            )
            pq.add(ptr)
        }

        var tweetsPulled = 0
        val result = mutableListOf<Int>()

        while (tweetsPulled < 10 && pq.isNotEmpty()) {
            val latestTweetPtr = pq.poll()
            result.add(latestTweetPtr.currentTweet.id)
            tweetsPulled++

            if (latestTweetPtr.iterator.hasNext()) {
                latestTweetPtr.currentTweet = latestTweetPtr.iterator.next()
                pq.add(latestTweetPtr)
            }
        }

        return result
    }

    fun follow(followerId: Int, followeeId: Int) {
        userFollows
            .getOrPut(followerId) { mutableSetOf() }
            .add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        userFollows.get(followerId)?.remove(followeeId)
    }

    data class TweetPointer(
        var currentTweet: Tweet,
        val iterator: Iterator<Tweet>
    )

    data class Tweet(
        val id: Int,
        val createdAt: Int
    )
}

package design

import java.util.*

/**
 * 设计推特
 */
private var sId = 0

class Twitter {
    class Tweet(val id: Int) : Comparable<Tweet> {
        var next: Tweet? = null
        private val time = sId++
        override fun compareTo(other: Tweet): Int {
            return other.time.compareTo(this.time)
        }
    }

    /** Initialize your data structure here. */
    private val userFollowMap = mutableMapOf<Int, MutableSet<Int>>()
    private val userTweetsMap = mutableMapOf<Int, Tweet>()

    /** Compose a new tweet. */
    fun postTweet(userId: Int, tweetId: Int) {
        val newTweet = Tweet(tweetId)
        val tweet = userTweetsMap[userId]
        if (tweet == null) {
            userTweetsMap[userId] = newTweet
        } else {
            newTweet.next = tweet
            userTweetsMap[userId] = newTweet
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    fun getNewsFeed(userId: Int): List<Int> {
        val followers = userFollowMap.getOrDefault(userId, mutableSetOf())
        // 关注的人包括自己
        followers.add(userId)
        val pq = PriorityQueue<Tweet>(10)
        for (user in followers) {
            if (userTweetsMap.containsKey(user)) {
                pq.add(userTweetsMap[user])
            }
        }

        val ans = mutableListOf<Int>()
        while (pq.isNotEmpty() && ans.size < 10) {
            val tweet = pq.poll()
            ans.add(tweet.id)
            if (tweet.next != null) {
                pq.add(tweet.next)
            }
        }
        return ans
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    fun follow(followerId: Int, followeeId: Int) {
        val set = userFollowMap.getOrDefault(followerId, mutableSetOf())
        set.add(followeeId)
        userFollowMap[followerId] = set
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    fun unfollow(followerId: Int, followeeId: Int) {
        val set = userFollowMap.getOrDefault(followerId, mutableSetOf())
        set.remove(followeeId)
        userFollowMap[followerId] = set
    }
}

fun main() {
    val twitter = Twitter()

// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
    twitter.postTweet(1, 5);
    twitter.postTweet(1, 3);
// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
    println(twitter.getNewsFeed(1))

// 用户1关注了用户2.
    twitter.follow(1, 2);

// 用户2发送了一个新推文 (推文id = 6).
    twitter.postTweet(2, 6);

// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
// 推文id6应当在推文id5之前，因为它是在5之后发送的.
    println(twitter.getNewsFeed(1))

// 用户1取消关注了用户2.
    twitter.unfollow(1, 2);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
// 因为用户1已经不再关注用户2.
    println(twitter.getNewsFeed(1))
}
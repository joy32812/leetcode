package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 11/05/2017.
 */
public class P355_DesignTwitter {



}



class Twitter {

    private class Tweet {
        int time;
        int tweetId;

        public Tweet(int time, int tweetId) {
            this.time = time;
            this.tweetId = tweetId;
        }
    }

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, LinkedList<Tweet>> tweetMap;
    int nowTime;

    /** Initialize your data structure here. */
    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        nowTime = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new LinkedList<>()).add(new Tweet(++nowTime, tweetId));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> (b.time - a.time));

        Set<Integer> followSet = followMap.computeIfAbsent(userId, k -> new HashSet<Integer>());
        followSet.add(userId);
        for (int fid : followSet) {
            LinkedList<Tweet> tweets = tweetMap.computeIfAbsent(fid, k -> new LinkedList<Tweet>());
            for (int i = tweets.size() - 1, k = 0; i >= 0 && k < 10; i--, k++) {
                pq.add(tweets.get(i));
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (ans.size() < 10 && !pq.isEmpty()) {
            ans.add(pq.poll().tweetId);
        }

        return ans;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).remove(followeeId);
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
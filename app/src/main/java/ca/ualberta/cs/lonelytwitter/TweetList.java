package ca.ualberta.cs.lonelytwitter;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by weixiang on 10/12/17.
 */

public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void addTweet(Tweet tweet) {
        if (hasTweet(tweet)) {
            throw new IllegalArgumentException();
        }
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int index) {
        return tweets.get(index);
    }

    public ArrayList<Tweet> getTweets() {
        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet t1, Tweet t2) {
                return t1.getDate().compareTo(t2.getDate());
            }
        });
        Log.i("TWEET1", tweets.get(0).getDate().toString());
        Log.i("TWEET2", tweets.get(1).getDate().toString());
        Log.i("TWEET3", tweets.get(2).getDate().toString());
        return tweets;
    }

    public int getCount() {
        return tweets.size();
    }

    public void deleteTweet(Tweet tweet) {
        tweets.remove(tweet);
    }

}

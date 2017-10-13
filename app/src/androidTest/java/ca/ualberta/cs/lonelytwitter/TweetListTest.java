package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by weixiang on 10/12/17.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Adding Tweet");
        try {
            tweets.addTweet(tweet);
            tweets.addTweet(tweet);
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    public void testDelete() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test");
        tweets.addTweet(tweet);
        tweets.deleteTweet(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testHasTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test");
        tweets.addTweet(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test");
        tweets.addTweet(tweet);
        Tweet returnedTweet = tweets.getTweet(0);
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
    }

    public void testGetTweets() {
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("Test");
        tweet1.setDate(new Date(1000));
        Tweet tweet2 = new NormalTweet("Test");
        tweet2.setDate(new Date(2000));
        Tweet tweet3 = new NormalTweet("Test");
        tweet3.setDate(new Date(3000));
        tweets.addTweet(tweet2);
        tweets.addTweet(tweet3);
        tweets.addTweet(tweet1);
        ArrayList<Tweet> sortedTweets = tweets.getTweets();
        assertTrue(sortedTweets.get(0).getDate().compareTo(sortedTweets.get(1).getDate()) < 0);
        assertTrue(sortedTweets.get(1).getDate().compareTo(sortedTweets.get(2).getDate()) < 0);
    }


}

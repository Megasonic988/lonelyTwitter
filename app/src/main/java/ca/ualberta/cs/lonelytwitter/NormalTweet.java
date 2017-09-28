/**
 * NormalTweet class
 *
 * Copyright 2017 Kevin Wang
 *
 * @author weixiang
 * @version 1.0
 * @created 2017-09-27
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * NormalTweet is a subclass of Tweet that is not
 * important.
 */
public class NormalTweet extends Tweet {

    /**
     * Constructor for NormalTweet with a string for the tweet text
     * and a custom date of creation.
     * @param tweet
     * @param date
     * @throws TweetTooLongException
     */
    public NormalTweet(String tweet, Date date) throws TweetTooLongException {
        super(tweet, date);
    }

    /**
     * Constructor for NormalTweet with a string for the tweet text.
     * The date of the tweet defaults to the current time.
     * @param tweet
     * @throws TweetTooLongException
     */
    public NormalTweet(String tweet) throws TweetTooLongException {
        super(tweet);
    }

    /**
     * NormalTweet is not important.
     * @return
     */
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}

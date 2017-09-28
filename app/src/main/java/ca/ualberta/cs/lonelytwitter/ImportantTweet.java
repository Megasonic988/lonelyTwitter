/**
 * ImportantTweet class
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
 * ImportantTweet is a subclass of Tweet that is not
 * important.
 */
public class ImportantTweet extends Tweet {

    /**
     * Constructor for ImportantTweet with a string for the tweet text
     * and a custom date of creation.
     * @param tweet
     * @param date
     * @throws TweetTooLongException
     */
    public ImportantTweet(String tweet, Date date) throws TweetTooLongException {
        super(tweet, date);
        this.setText(tweet);
        this.date = date;
    }

    /**
     * Constructor for ImportantTweet with a string for the tweet text.
     * The date of the tweet defaults to the current time.
     * @param tweet
     * @throws TweetTooLongException
     */
    public ImportantTweet(String tweet) throws TweetTooLongException {
        super(tweet);
    }

    /**
     * ImportantTweet is important.
     * @return isImportant
     */
    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    /**
     * Get the text of the tweet.
     * @return text
     */
    @Override
    public String getText() {
        return "!!!" + super.getText();
    }

}

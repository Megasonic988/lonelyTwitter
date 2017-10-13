/**
 * Tweet class
 *
 * Copyright 2017 Kevin Wang
 *
 * @author weixiang
 * @version 1.0
 * @created 2017-09-27
 */

package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * The Tweet class represents a tweet which is a text message with
 * a date and a list of moods that accompany the tweet.
 * @author weixiang
 * @version 1.0
 */
public abstract class Tweet extends Object implements Tweetable {
    private String text;
    protected Date date;
    private ArrayList<Mood> moods = new ArrayList<Mood>();

    /**
     * Constructor for Tweet with a string for the tweet text
     * and a custom date of creation.
     * @param tweet
     * @param date
     * @throws TweetTooLongException
     */
    public Tweet(String tweet, Date date) throws TweetTooLongException {
        this.setText(tweet);
        this.date = date;
    }

    /**
     * Constructor for Tweet with a string for the tweet text.
     * The date of the tweet defaults to the current time.
     * @param tweet
     * @throws TweetTooLongException
     */
    public Tweet(String tweet) throws TweetTooLongException {
        this.setText(tweet);
        this.date = new Date();
    }

    /**
     * Get the text string of the Tweet.
     * @return text
     */
    public String getText() {
        return text;
    }

    public String getMessage() {
        return getText();
    }


    /**
     * Set the text string of the Tweet.
     * @param text
     * @throws TweetTooLongException
     */
    public void setText(String text) throws TweetTooLongException {
        if (text.length() <= 140) {
            this.text = text;
        } else {
            throw new TweetTooLongException();
        }
    }

    /**
     * Add a mood to the Tweet.
     * @param mood
     */
    public void addMood(Mood mood) {
        moods.add(mood);
    }

    /**
     * Remove a mood from the Tweet.
     * @param mood
     */
    public void removeMood(Mood mood) {
        moods.remove(mood);
    }

    /**
     * Get the moods of the Tweet.
     * @return moods
     */
    public ArrayList<Mood> getMoods() {
        return moods;
    }

    /**
     * Get the date of the Tweet.
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set the date of the Tweet.
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Method to check whether the Tweet is important.
     * @return isImportant
     */
    public abstract Boolean isImportant();

    /**
     * Returns string representation of the Tweet.
     * @return string
     */
    @Override
    public String toString() {
        return date.toString() + " | " + text;
    }
}

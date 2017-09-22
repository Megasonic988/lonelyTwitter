package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by weixiang on 9/14/17.
 */

public abstract class Tweet extends Object implements Tweetable {
    private String text;
    protected Date date;
    private ArrayList<Mood> moods = new ArrayList<Mood>();

    public Tweet(String tweet, Date date) throws TweetTooLongException {
        this.setText(tweet);
        this.date = date;
    }

    public Tweet(String tweet) throws TweetTooLongException {
        this.setText(tweet);
        this.date = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) throws TweetTooLongException {
        if (text.length() <= 140) {
            this.text = text;
        } else {
            throw new TweetTooLongException();
        }
    }

    public void addMood(Mood mood) {
        moods.add(mood);
    }

    public void removeMood(Mood mood) {
        moods.remove(mood);
    }

    public ArrayList<Mood> getMoods() {
        return moods;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract Boolean isImportant();

    @Override
    public String toString() {
        return date.toString() + " | " + text;
    }
}

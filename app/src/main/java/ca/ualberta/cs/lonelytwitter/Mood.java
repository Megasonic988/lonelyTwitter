/**
 * Mood class
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
 * The Mood class represents a mood with a
 * date of creation and a mood string. Mood is an
 * abstract class. Subclasses must implement getMood.
 */
public abstract class Mood {

    private Date date;

    /**
     * Constructor for mood with a date that defaults
     * to the current time.
     */
    public void Mood() {
        this.date = new Date();
    };

    /**
     * Constructor for mood with a custom date.
     * @param date
     */
    public void Mood(Date date) {
        this.date = date;
    }

    /**
     * Get the creation date of the mood.
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set the date of the mood.
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Get the string representing the mood. Abstract.
     * @return mood
     */
    abstract public String getMood();
}

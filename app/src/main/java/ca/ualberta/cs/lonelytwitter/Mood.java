package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by weixiang on 9/14/17.
 */

public abstract class Mood {

    private Date date;

    public void Mood() {
        this.date = new Date();
    };

    public void Mood(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate() {
        this.date = date;
    }

    abstract public String getMood();
}

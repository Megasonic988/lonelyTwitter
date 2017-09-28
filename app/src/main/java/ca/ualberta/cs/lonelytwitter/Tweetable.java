/**
 * Tweetable class
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
 * The Tweetable interface specifies that a class
 * must implement getText and getDate.
 */
public interface Tweetable {
    public String getText();
    public Date getDate();
}

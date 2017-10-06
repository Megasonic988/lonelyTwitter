package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by weixiang on 10/5/17.
 */

public interface AsyncResponse {
    void processFetchedTweets(ArrayList<NormalTweet> tweets);
}

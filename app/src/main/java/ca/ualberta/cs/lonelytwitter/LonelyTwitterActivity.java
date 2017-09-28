/**
 * LonelyTwitterActivity class
 *
 * Copyright 2017 Kevin Wang
 *
 * @author weixiang
 * @version 1.0
 * @created 2017-09-27
 */

package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

/**
 * LonelyTwitterActivity is the main activity for the Lonely
 * Twitter app. It displays an interface with a list of Tweets
 * and a text field for adding new Tweets. On app start, the Tweets
 * are loaded from a file in JSON format. Actions to the
 * tweets are saved in the file.
 */
public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;

	/**
	 * onCreate sets up links between UI elements and controller
	 * actions. Causes save button to trigger adding the
	 * new Tweet to the tweets list and saves the Tweet
	 * into a file.
	 * @param savedInstanceState
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
        Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				tweets.add(new NormalTweet(text));
                saveInFile();
				adapter.notifyDataSetChanged();

			}
		});

        clearButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                clearTweets();
            }
        });
	}

	/**
	 * onStart loads the Tweets from the saved file. It also
	 * sets up the adapter for the tweets list.
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
        loadFromFile();
        if (tweets == null) {
            throw new RuntimeException();
        }
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * Load the Tweets from a file using Gson library.
	 * If no file is found, create a new file.
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();

            Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
            tweets = gson.fromJson(in, listType);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

	/**
	 * Save the Tweets in the tweets list to a file
	 * in JSON format, using the Gson library.
	 */
	private void saveInFile() {
		try {
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_APPEND);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(tweets, writer);
            writer.flush();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}

	/**
	 * Clear the tweets list and delete the file
	 * where tweets are saved.
	 */
	private void clearTweets() {
        tweets.clear();
        adapter.notifyDataSetChanged();
        File dir = getFilesDir();
        File file = new File(dir, FILENAME);
        file.delete();

    }
}
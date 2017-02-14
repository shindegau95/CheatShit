package com.pkg.android.cheatshit;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CheatActivity extends AppCompatActivity {
    private EditText noOfWords;
    private EditText movieName;
    private Button search;
    private ProgressBar progressBar;
    private int count;
    private int choice;
    private static final String EXTRA_CHOICE = "com.pkg.android.cheatshit.extra_choice";
    private TextView results;

    public static Intent newIntent(Context packageContext, int wood) {
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_CHOICE, wood);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        noOfWords = (EditText) findViewById(R.id.no_of_words);
        movieName = (EditText) findViewById(R.id.movie_name);
        search = (Button) findViewById(R.id.button);
        results = (TextView) findViewById(R.id.results);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        choice = getIntent().getIntExtra(EXTRA_CHOICE, 1);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                results.setText("");
                //Toast.makeText(CheatActivity.this, "n = " + noOfWords.getText().toString() + ", movie name = " + movieName.getText().toString() + ", choice = " + choice, Toast.LENGTH_SHORT).show();
                count = 1;
                if(movieName.getText().toString().split(" ").length == Integer.parseInt(noOfWords.getText().toString())){
                    new Search(Integer.parseInt(noOfWords.getText().toString()), movieName.getText().toString()).execute(10);
                }
                else{
                    Toast.makeText(CheatActivity.this, "Invalid Input check no. of words", Toast.LENGTH_SHORT).show();
                    noOfWords.setText("");
                    movieName.setText("");
                }

            }
        });
    }

    public class Search extends AsyncTask<Integer, Integer, List<String>> {
        private static final String TAG = "Search";
        int noOfWords;
        String movieName;

        public Search(int noOfWords, String movieName) {
            this.noOfWords = noOfWords;
            this.movieName = movieName;
        }

        @Override
        protected void onPreExecute() {
            progressBar.setMax(10);
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setProgress(0);
        }

        @Override
        protected void onPostExecute(List<String> result) {
            progressBar.setVisibility(View.GONE);
            for (String s:result){
                results.append(s + "\n");
            }

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0]);
        }

        @Override
        protected List<String> doInBackground(Integer... params) {
            for (; count < params[0]; count++) {
                try {
                    Thread.sleep(100);
                    publishProgress(count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Log.d(TAG, "from AsyncTask, no = " + noOfWords + ", movie name = " + movieName);
            Set<String> s = ComputeAlgorithm.compute(getApplicationContext(), choice, movieName.toLowerCase(), noOfWords);
            Log.d(TAG, Arrays.asList(s).toString());
            return new ArrayList<String>(s);
        }
    }
}

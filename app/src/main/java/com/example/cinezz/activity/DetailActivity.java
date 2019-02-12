package com.example.cinezz.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.cinezz.R;
import com.example.cinezz.model.MovieShowtime;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();

    MovieShowtime movieShowTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        movieShowTime = (MovieShowtime)getIntent().getSerializableExtra("movieShowTime");
        Log.d(TAG,movieShowTime.getTitle());

        setTitle(movieShowTime.getTitle());
    }
}

package com.example.cinezz.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import com.example.cinezz.CustomListAdapter;
import com.example.cinezz.R;
import com.example.cinezz.model.Global;
import com.example.cinezz.model.MovieShowtime;
import com.example.cinezz.rest.ApiHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;

public class MainActivity extends AppCompatActivity implements CustomListAdapter.OnMovieClickedListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;


    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"coucou je suis un log");
        mRecyclerView = findViewById(R.id.recyclerViewId);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        ApiHelper.getInstance().getShowTimeApi().getGlobal().enqueue(new Callback<Global>() {
            @Override
            public void onResponse(Call<Global> call, Response<Global> response) {
                Log.d(TAG,"response API");
                if (response.isSuccessful()) {
                    Global global = response.body();

                    // specify an adapter (see also next example)
                    mAdapter = new CustomListAdapter(global.getMovieShowtimes(), MainActivity.this);
                    mRecyclerView.setAdapter(mAdapter);

                } else {
                    //TODO handle failure
                }
            }

            @Override
            public void onFailure(Call<Global> call, Throwable t) {
                Log.e(TAG,"error");
            }
        });
    }

    @Override
    public void onMovieClicked(MovieShowtime movieShowtime) {
        // We want an app that display content
        Log.d(TAG,"movie clicked");
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("movieShowTime", movieShowtime);
        startActivity(intent);
    }
}

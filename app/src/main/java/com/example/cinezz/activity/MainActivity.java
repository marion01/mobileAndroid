package com.example.cinezz.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import com.example.cinezz.CustomListAdapter;
import com.example.cinezz.R;
import com.example.cinezz.model.Global;
import com.example.cinezz.rest.ApiHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    String[] titleArray = {"Octopus","Pig","Sheep","Rabbit","Snake","Spider" };

    String[] pressRatingArray = {
            "8 tentacled monster",
            "Delicious in rolls",
            "Great for jumpers",
            "Nice in a stew",
            "Great for shoes",
            "Scary."
    };

    String[] userRatingArray = {
            "8 tentacled monster",
            "Delicious in rolls",
            "Great for jumpers",
            "Nice in a stew",
            "Great for shoes",
            "Scary."
    };

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;


    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"coucou je suis un log");


        ApiHelper.getInstance().getShowTimeApi().getGlobal().enqueue(new Callback<Global>() {
            @Override
            public void onResponse(Call<Global> call, Response<Global> response) {

                if (response.isSuccessful()) {
                    Global global = response.body();

                    mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewId);

                    // use this setting to improve performance if you know that changes
                    // in content do not change the layout size of the RecyclerView
                    mRecyclerView.setHasFixedSize(true);

                    // specify an adapter (see also next example)
                    mAdapter = new CustomListAdapter(global.getMovieShowtimes());
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
}

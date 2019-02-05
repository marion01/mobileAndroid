package com.example.cinezz;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cinezz.model.Global;
import com.example.cinezz.model.MovieShowtime;

public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.MovieViewHolder>{

    MovieShowtime[] movieShowTimes;

    public CustomListAdapter(MovieShowtime[] movieShowTimesParam){
        movieShowTimes = movieShowTimesParam;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listlayout_row, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MovieShowtime movieTime = movieShowTimes[position];
        holder.title.setText(movieTime.getTitle());
        holder.pressRate.setText(movieTime.getStats().getPressRating());
        holder.userRate.setText(movieTime.getStats().getUserRating());
      //  holder.poster.
    }

    @Override
    public int getItemCount() {
        return movieShowTimes.length;
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView pressRate;
        TextView userRate;
       // ImageView poster;

        MovieViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.titleId);
            pressRate = view.findViewById(R.id.pressRateId);
            userRate = view.findViewById(R.id.userRateId);
          //  poster = view.findViewById(R.id.posterId);
        }
    }

}

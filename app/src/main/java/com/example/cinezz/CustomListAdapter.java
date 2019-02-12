package com.example.cinezz;

import android.app.Activity;
import android.graphics.drawable.Drawable;
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
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;

public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.MovieViewHolder>{

    MovieShowtime[] movieShowTimes;
    private OnMovieClickedListener listener;

    public CustomListAdapter(MovieShowtime[] movieShowTimesParam, OnMovieClickedListener onMovieClickedListener){
        movieShowTimes = movieShowTimesParam;
        this.listener = onMovieClickedListener;
    }

    public CustomListAdapter(){
        movieShowTimes = null;
    }

    public void setMovieShowTimes(MovieShowtime[] movieShowTimesParam){
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

        String imageUri = movieTime.getOnShow().getMovie().getPoster();
        Picasso.with(holder.itemView.getContext()).load(imageUri).into(holder.poster);

        holder.itemView.setOnClickListener(v -> listener.onMovieClicked(movieTime));
    }

    @Override
    public int getItemCount() {
        return movieShowTimes.length;
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView pressRate;
        TextView userRate;
        ImageView poster;

        MovieViewHolder(View view) {
            super(view);
            poster = view.findViewById(R.id.poster);
            title = view.findViewById(R.id.titleId);
            pressRate = view.findViewById(R.id.pressRateId);
            userRate = view.findViewById(R.id.userRateId);
        }
    }

    public interface OnMovieClickedListener {
        void onMovieClicked(MovieShowtime movieShowtime);
    }

}






package com.example.cinezz.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.cinezz.R;
import com.example.cinezz.model.MovieShowtime;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();

    MovieShowtime movieShowTime;
    TextView genre;
    TextView releaseDate;
    RatingBar userRating;
    RatingBar pressRating;
    TextView langue;
    ImageView poster;
    TextView runtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        movieShowTime = (MovieShowtime) getIntent().getSerializableExtra("movieShowTime");

        setTitle(movieShowTime.getTitle());

        genre = findViewById(R.id.genre);
        releaseDate = findViewById(R.id.releaseDate);
        userRating = findViewById(R.id.userRating);
        pressRating = findViewById(R.id.pressRating);
        langue = findViewById(R.id.langue);
        poster = findViewById(R.id.posterDetail);
        runtime = findViewById(R.id.time);

        if (movieShowTime.getOnShow().getMovie().getGenre() != null)
            genre.setText(movieShowTime.getOnShow().getMovie().getGenre());
        if (movieShowTime.getOnShow().getMovie().getReleaseDate() != null)
            releaseDate.setText(movieShowTime.getOnShow().getMovie().getReleaseDate());
        if (movieShowTime.getStats().getUserRating() != null)
            userRating.setRating(Float.parseFloat(movieShowTime.getStats().getUserRating()));
        if (movieShowTime.getStats().getPressRating() != null)
            pressRating.setRating(Float.parseFloat(movieShowTime.getStats().getPressRating()));
        if (movieShowTime.getVersion().getName() != null)
            langue.setText(movieShowTime.getVersion().getName());
        if (movieShowTime.getOnShow().getMovie().getRuntime() != null) {
            double time = Float.parseFloat(movieShowTime.getOnShow().getMovie().getRuntime());
            int heure = (int) time / 3600;
            int min = (int) (time - heure * 3600) / 60;
            String timeString = Integer.toString(heure) + "h" + Integer.toString(min);
            runtime.setText(timeString);
        }

        String imageUri = movieShowTime.getOnShow().getMovie().getPoster();
        Picasso.with(this).load(imageUri).into(poster);

        createLabels();

        createRuntimes();
    }

    //TODO change text to resource
    protected void createLabels() {

        TextView userRatingLabel = findViewById(R.id.userRatingLabel);
        userRatingLabel.setText("Spectateurs");

        TextView pressRatingLabel = findViewById(R.id.pressRatingLabel);
        pressRatingLabel.setText("Presse");

        TextView genreLabel = findViewById(R.id.genreLabel);
        genreLabel.setText("Genre :");

        TextView releaseDateLabel = findViewById(R.id.releaseDateLabel);
        releaseDateLabel.setText("Date de sortie :");

        TextView langueLabel = findViewById(R.id.langueLabel);
        langueLabel.setText("Langue :");

        TextView timeLabel = findViewById(R.id.timeLabel);
        timeLabel.setText("Durée :");

        TextView runtimesLabel = findViewById(R.id.runtimesLabel);
        runtimesLabel.setText("Séances :");



        Button buttonTrailer = findViewById(R.id.buttonTrailer);
        buttonTrailer.setText("voir le trailer");
        buttonTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClicked();
            }
        });
    }


    protected void onButtonClicked() {
        String trailer = movieShowTime.getOnShow().getMovie().getTrailer();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(trailer));
        startActivity(intent);
    }

    private void createRuntimes() {
        LinearLayout layoutGlobal = findViewById(R.id.globalLayoutDetail);

        for (int i = 0; i < movieShowTime.getScr().length; i++) {
            TextView date = new TextView(this);
            date.setText(movieShowTime.getScr()[0].getD());
            LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(42,50,0,0);
            date.setLayoutParams(lp);
            date.setTypeface(null, Typeface.BOLD);

            layoutGlobal.addView(date);

            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            for (int j = 0; j<movieShowTime.getScr()[i].getT().length ; j++){
                LinearLayout.LayoutParams lpt=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lpt.setMargins(42,0,20,0);
                TextView time = new TextView(this);
                time.setText(movieShowTime.getScr()[i].getT()[j].getName());
                time.setLayoutParams(lpt);
                linearLayout.addView(time);
            }
            layoutGlobal.addView(linearLayout);


        }
    }


}
package com.example.cinezz.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cinezz.R;
import com.example.cinezz.model.MovieShowtime;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();

    MovieShowtime movieShowTime;
    TextView genre;
    TextView releaseDate;
    TextView userRating;
    TextView pressRating;
    TextView langue;
    ImageView poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        movieShowTime = (MovieShowtime)getIntent().getSerializableExtra("movieShowTime");

        setTitle(movieShowTime.getTitle());

        genre = findViewById(R.id.genre);
        releaseDate = findViewById(R.id.releaseDate);
        userRating = findViewById(R.id.userRating);
        pressRating = findViewById(R.id.pressRating);
        langue = findViewById(R.id.langue);
        poster = findViewById(R.id.posterDetail);

        genre.setText(movieShowTime.getOnShow().getMovie().getGenre());
        releaseDate.setText(movieShowTime.getOnShow().getMovie().getReleaseDate());
        userRating.setText(movieShowTime.getStats().getUserRating());
        pressRating.setText(movieShowTime.getStats().getPressRating());
        langue.setText(movieShowTime.getVersion().getName());


        String imageUri = movieShowTime.getOnShow().getMovie().getPoster();
        Picasso.with(this).load(imageUri).into(poster);

        createLabels();
    }

    //TODO change text to resource
    protected void createLabels(){
        TextView ratingLabel = findViewById(R.id.ratingLabel);
        ratingLabel.setText("Notes");

        TextView userRatingLabel = findViewById(R.id.userRatingLabel);
        userRatingLabel.setText("note spectateurs : ");

        TextView pressRatingLabel = findViewById(R.id.pressRatingLabel);
        pressRatingLabel.setText("note presse : ");

        Button buttonTrailer = findViewById(R.id.buttonTrailer);
        buttonTrailer.setText("voir le trailer");
        buttonTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClicked();
            }
        });
    }


    protected void onButtonClicked(){
        String trailer = movieShowTime.getOnShow().getMovie().getTrailer();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(trailer));
        startActivity(intent);
    }
}

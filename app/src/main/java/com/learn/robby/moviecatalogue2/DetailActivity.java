package com.learn.robby.moviecatalogue2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.learn.robby.moviecatalogue2.Model.Movie;
import com.learn.robby.moviecatalogue2.Model.Tv;

public class DetailActivity extends AppCompatActivity {

    TextView txtTitle, txtScore, txtRuntime, txtLanguage, txtDesc, txtDate;
    ImageView imgFilm;

    String dTitle, dScore, dRuntime, dLanguage, dDesc, dDate, dFact;
    int dImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtTitle = findViewById(R.id.txt_title);
        txtDate = findViewById(R.id.txt_date);
        txtScore = findViewById(R.id.txt_score);
        txtRuntime = findViewById(R.id.txt_runtime);
        txtLanguage = findViewById(R.id.txt_language);
        txtDesc = findViewById(R.id.txt_desc);
        imgFilm = findViewById(R.id.img_film);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle(R.string.app_detail_film);

        Intent intent = getIntent();
        if(intent.hasExtra("Movie")){
            Movie movie = intent.getParcelableExtra("Movie");
            dTitle = movie.getTitle();
            dDesc = movie.getDescription();
            dImg = movie.getPhoto();
            dFact = movie.getFact();
            String[] arrFact = dFact.split("-");
            txtScore.setText(arrFact[0]+"%");
            txtLanguage.setText(arrFact[1]);
            txtRuntime.setText(arrFact[2]);
            txtDate.setText(arrFact[3]);
            insert(dTitle,dDesc,dImg);
        } if(intent.hasExtra("Tv")){
            Tv tv = intent.getParcelableExtra("Tv");
            dTitle = tv.getTitle();
            dDesc = tv.getDescription();
            dImg = tv.getPhoto();
            dFact = tv.getFact();
            String[] arrFact = dFact.split("-");
            txtScore.setText(arrFact[0]+"%");
            txtLanguage.setText(arrFact[1]);
            txtRuntime.setText(arrFact[2]);
            txtDate.setText(arrFact[3]);
            insert(dTitle,dDesc,dImg);
        }
    }
    public void insert(String title, String desc, int img){
        txtTitle.setText(title);
        txtDesc.setText(desc);
        imgFilm.setImageResource(img);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return super.onOptionsItemSelected(item);
    }
}

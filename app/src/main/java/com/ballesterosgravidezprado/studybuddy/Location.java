package com.ballesterosgravidezprado.studybuddy;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Location extends Activity {

    private View locationbg;
    private ImageView studybuddylogo;
    private TextView locationquestion;
    private TextView cavite;
    private TextView cebu;
    private TextView davao;
    private TextView laguna;
    private TextView manila;
    private TextView makati;
    private ImageView backbutton;
    private TextView back;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location);

        locationbg = findViewById(R.id.locationbg);
        studybuddylogo = findViewById(R.id.studybuddylogo);
        locationquestion = findViewById(R.id.locationquestion);
        cavite = findViewById(R.id.cavite);
        cebu = findViewById(R.id.cebu);
        davao = findViewById(R.id.davao);
        laguna = findViewById(R.id.laguna);
        manila = findViewById(R.id.manila);
        makati = findViewById(R.id.makati);
        backbutton = findViewById(R.id.backbutton);
        back = findViewById(R.id.back);

        studybuddylogo.setOnClickListener(v -> {
            Intent intent = new Intent(Location.this, Homepage.class);
            startActivity(intent);
            finish();
        });

        cavite.setOnClickListener(v -> {
            Intent intent = new Intent(Location.this, DistanceRange.class);
            startActivity(intent);
        });

        cebu.setOnClickListener(v -> {
            Intent intent = new Intent(Location.this, DistanceRange.class);
            startActivity(intent);
        });

        davao.setOnClickListener(v -> {
            Intent intent = new Intent(Location.this, DistanceRange.class);
            startActivity(intent);
        });

        laguna.setOnClickListener(v -> {
            Intent intent = new Intent(Location.this, DistanceRange.class);
            startActivity(intent);
        });

        manila.setOnClickListener(v -> {
            Intent intent = new Intent(Location.this, DistanceRange.class);
            startActivity(intent);
        });

        makati.setOnClickListener(v -> {
            Intent intent = new Intent(Location.this, DistanceRange.class);
            startActivity(intent);
        });

        View.OnClickListener backListener = v -> {
            Intent intent = new Intent(Location.this, SessionType.class);
            startActivity(intent);
            finish();
        };

        backbutton.setOnClickListener(backListener);
        back.setOnClickListener(backListener);
    }
}

package com.ballesterosgravidezprado.studybuddy;

import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Homepage extends Activity {

    private View homepagebg;
    private ImageView studybuddylogo;
    private TextView welcomemessage;
    private TextView doctor;
    private TextView grammarian;
    private TextView mathematician;
    private TextView professor;
    private TextView psychometrician;
    private TextView scientist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        homepagebg = findViewById(R.id.homepagebg);
        studybuddylogo = findViewById(R.id.studybuddylogo);
        welcomemessage = findViewById(R.id.welcomemessage);
        doctor = findViewById(R.id.doctor);
        grammarian = findViewById(R.id.grammarian);
        mathematician = findViewById(R.id.mathematician);
        professor = findViewById(R.id.professor);
        psychometrician = findViewById(R.id.psychometrician);
        scientist = findViewById(R.id.scientist);

        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSessionType();
            }
        });

        grammarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSessionType();
            }
        });

        mathematician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSessionType();
            }
        });

        professor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSessionType();
            }
        });

        psychometrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSessionType();
            }
        });

        scientist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSessionType();
            }
        });
    }

    private void navigateToSessionType() {
        Intent intent = new Intent(Homepage.this, SessionType.class);
        startActivity(intent);
    }
}
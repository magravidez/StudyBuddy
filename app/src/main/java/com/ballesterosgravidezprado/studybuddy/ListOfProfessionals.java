package com.ballesterosgravidezprado.studybuddy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class ListOfProfessionals extends Activity {

    private View listofprofessionalsbg;
    private ImageView studybuddylogo;
    private View jenniekimview;
    private TextView jenniekim;
    private TextView aboutjenniekim;
    private ImageView jenniekimimage;
    private View mattyhealyview;
    private TextView mattyhealy;
    private TextView aboutmattyhealy;
    private ImageView mattyhealyimage;
    private View robertpattinsonview;
    private TextView robertpattinson;
    private TextView aboutrobertpattinson;
    private ImageView robertpattinsonimage;
    private View shinryujinview;
    private TextView shinryujin;
    private TextView aboutshinryujin;
    private ImageView shinryujinimage;
    private View willierevillameview;
    private TextView willierevillame;
    private TextView aboutwillierevillame;
    private ImageView willierevillameimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listofprofessionals);

        ImageView backImage = findViewById(R.id.studybuddylogo);
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListOfProfessionals.this, Homepage.class);
                startActivity(intent);
                finish();
            }
        });

        listofprofessionalsbg = findViewById(R.id.listofprofessionalsbg);
        studybuddylogo = findViewById(R.id.studybuddylogo);

        jenniekimview = findViewById(R.id.jenniekimview);
        jenniekim = findViewById(R.id.jenniekim);
        aboutjenniekim = findViewById(R.id.aboutjenniekim);
        jenniekimimage = findViewById(R.id.jenniekimimage);

        mattyhealyview = findViewById(R.id.mattyhealyview);
        mattyhealy = findViewById(R.id.mattyhealy);
        aboutmattyhealy = findViewById(R.id.aboutmattyhealy);
        mattyhealyimage = findViewById(R.id.mattyhealyimage);

        robertpattinsonview = findViewById(R.id.robertpattinsonview);
        robertpattinson = findViewById(R.id.robertpattinson);
        aboutrobertpattinson = findViewById(R.id.aboutrobertpattinson);
        robertpattinsonimage = findViewById(R.id.robertpattinsonimage);

        shinryujinview = findViewById(R.id.shinryujinview);
        shinryujin = findViewById(R.id.shinryujin);
        aboutshinryujin = findViewById(R.id.aboutshinryujin);
        shinryujinimage = findViewById(R.id.shinryujinimage);

        willierevillameview = findViewById(R.id.willierevillameview);
        willierevillame = findViewById(R.id.willierevillame);
        aboutwillierevillame = findViewById(R.id.aboutwillierevillame);
        willierevillameimage = findViewById(R.id.willierevillameimage);

        jenniekimview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListOfProfessionals.this, JennieKim.class);
                startActivity(intent);
            }
        });

        mattyhealyview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListOfProfessionals.this, MattyHealy.class);
                startActivity(intent);
            }
        });

        robertpattinsonview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListOfProfessionals.this, RobertPattinson.class);
                startActivity(intent);
            }
        });

        shinryujinview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListOfProfessionals.this, ShinRyujin.class);
                startActivity(intent);
            }
        });

        willierevillameview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListOfProfessionals.this, WillieRevillame.class);
                startActivity(intent);
            }
        });
    }
}
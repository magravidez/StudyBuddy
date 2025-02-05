package com.ballesterosgravidezprado.studybuddy;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DistanceRange extends Activity {

    private View distancerangebg;
    private ImageView studybuddylogo;
    private TextView distancerangequestion;
    private TextView onetothreekm;
    private TextView fourtosixkm;
    private TextView seventotenkm;
    private TextView doesntmatter;
    private ImageView backbutton;
    private TextView back;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.distancerange);

        distancerangebg = findViewById(R.id.distancerangebg);
        studybuddylogo = findViewById(R.id.studybuddylogo);
        distancerangequestion = findViewById(R.id.distancerangequestion);
        onetothreekm = findViewById(R.id.onetothreekm);
        fourtosixkm = findViewById(R.id.fourtosixkm);
        seventotenkm = findViewById(R.id.seventotenkm);
        doesntmatter = findViewById(R.id.doesntmatter);
        backbutton = findViewById(R.id.backbutton);
        back = findViewById(R.id.back);

        View.OnClickListener goToBudgetListener = v -> {
            Intent intent = new Intent(DistanceRange.this, Budget.class);
            startActivity(intent);
        };

        onetothreekm.setOnClickListener(goToBudgetListener);
        fourtosixkm.setOnClickListener(goToBudgetListener);
        seventotenkm.setOnClickListener(goToBudgetListener);
        doesntmatter.setOnClickListener(goToBudgetListener);

        View.OnClickListener backListener = v -> {
            Intent intent = new Intent(DistanceRange.this, Location.class);
            startActivity(intent);
            finish();
        };

        backbutton.setOnClickListener(backListener);
        back.setOnClickListener(backListener);

        studybuddylogo.setOnClickListener(v -> {
            Intent intent = new Intent(DistanceRange.this, Homepage.class);
            startActivity(intent);
            finish();
        });
    }
}
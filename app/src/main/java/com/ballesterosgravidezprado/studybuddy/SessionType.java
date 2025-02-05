package com.ballesterosgravidezprado.studybuddy;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SessionType extends Activity {

    private View sessiontypebg;
    private ImageView studybuddylogo;
    private TextView sessiontypequestion, online, facetoface, both, back;
    private ImageView backbutton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sessiontype);

        initializeViews();
        setListeners();
    }

    private void initializeViews() {
        sessiontypebg = findViewById(R.id.sessiontypebg);
        studybuddylogo = findViewById(R.id.studybuddylogo);
        sessiontypequestion = findViewById(R.id.sessiontypequestion);
        online = findViewById(R.id.online);
        facetoface = findViewById(R.id.facetoface);
        both = findViewById(R.id.both);
        backbutton = findViewById(R.id.backbutton);
        back = findViewById(R.id.back);
    }

    private void setListeners() {
        studybuddylogo.setOnClickListener(view -> {
            Intent intent = new Intent(SessionType.this, Homepage.class);
            startActivity(intent);
            finish();
        });

        online.setOnClickListener(v -> {
            Intent intent = new Intent(SessionType.this, Location.class);
            startActivity(intent);
        });

        facetoface.setOnClickListener(v -> {
            Intent intent = new Intent(SessionType.this, Location.class);
            startActivity(intent);
        });

        both.setOnClickListener(v -> {
            Intent intent = new Intent(SessionType.this, Location.class);
            startActivity(intent);
        });

        View.OnClickListener backListener = v -> {
            Intent intent = new Intent(SessionType.this, Homepage.class);
            startActivity(intent);
            finish();
        };

        backbutton.setOnClickListener(backListener);
        back.setOnClickListener(backListener);
    }
}
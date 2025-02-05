package com.ballesterosgravidezprado.studybuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProgressBar_Complete extends Activity {

    private View progressbar_completebg;
    private ImageView studybuddylogo;
    private TextView progressbar_completetext, press;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressbar_complete);

        progressbar_completebg = findViewById(R.id.progressbar_completebg);
        studybuddylogo = findViewById(R.id.studybuddylogo);
        progressbar_completetext = findViewById(R.id.progressbar_completetext);
        press = findViewById(R.id.press);

        studybuddylogo.setOnClickListener(v -> {
            Intent intent = new Intent(ProgressBar_Complete.this, Homepage.class);
            startActivity(intent);
            finish();
        });

        press.setOnClickListener(v -> {
            Intent intent = new Intent(ProgressBar_Complete.this, ListOfProfessionals.class);
            startActivity(intent);
        });
    }
}
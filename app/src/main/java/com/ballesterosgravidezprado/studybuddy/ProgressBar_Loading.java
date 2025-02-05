package com.ballesterosgravidezprado.studybuddy;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBar_Loading extends Activity {

    private View progressbar_loadingbg;
    private ImageView studybuddylogo;
    private TextView progressbar_loadingtext;
    private ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressbar_loading);

        progressbar_loadingbg = findViewById(R.id.progressbar_loadingbg);
        studybuddylogo = findViewById(R.id.studybuddylogo);
        progressbar_loadingtext = findViewById(R.id.progressbar_loadingtext);
        progressBar = findViewById(R.id.progressBar);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(ProgressBar_Loading.this, ProgressBar_Complete.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
            finish();
        }, 3000);
    }
}
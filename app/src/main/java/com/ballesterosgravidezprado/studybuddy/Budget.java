package com.ballesterosgravidezprado.studybuddy;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Budget extends Activity {

    private View budgetbg;
    private ImageView studybuddylogo;
    private TextView budgetquestion;
    private TextView optionone;
    private TextView optiontwo;
    private TextView optionthree;
    private TextView optionfour;
    private ImageView backbutton;
    private TextView back;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budget);

        budgetbg = findViewById(R.id.budgetbg);
        studybuddylogo = findViewById(R.id.studybuddylogo);
        budgetquestion = findViewById(R.id.budgetquestion);
        optionone = findViewById(R.id.optionone);
        optiontwo = findViewById(R.id.optiontwo);
        optionthree = findViewById(R.id.optionthree);
        optionfour = findViewById(R.id.optionfour);
        backbutton = findViewById(R.id.backbutton);
        back = findViewById(R.id.back);

        View.OnClickListener goToProgressBarListener = v -> {
            Intent intent = new Intent(Budget.this, ProgressBar_Loading.class);
            startActivity(intent);
        };

        optionone.setOnClickListener(goToProgressBarListener);
        optiontwo.setOnClickListener(goToProgressBarListener);
        optionthree.setOnClickListener(goToProgressBarListener);
        optionfour.setOnClickListener(goToProgressBarListener);

        View.OnClickListener backListener = v -> {
            Intent intent = new Intent(Budget.this, DistanceRange.class);
            startActivity(intent);
            finish();
        };

        backbutton.setOnClickListener(backListener);
        back.setOnClickListener(backListener);

        studybuddylogo.setOnClickListener(v -> {
            Intent intent = new Intent(Budget.this, Homepage.class);
            startActivity(intent);
            finish();
        });
    }
}
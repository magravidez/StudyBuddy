package com.ballesterosgravidezprado.studybuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.net.Uri;

public class MattyHealy extends Activity {

    private ImageView studybuddylogo, mattyhealyimage, backbutton, firststar, secondstar, thirdstar, fourthstar, fifthstar, email, telephone, chaticon, videocallicon, book;
    private TextView back, mattyhealy, mhreviews, aboutmattyhealy, contactdetails, whattodonext, mhnumber, mhemail, bookanappointment, chat, videocall;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mattyhealy);
        initializeViews();
        setListeners();
    }

    private void initializeViews() {
        studybuddylogo = findViewById(R.id.studybuddylogo);
        mattyhealyimage = findViewById(R.id.mattyhealyimage);
        backbutton = findViewById(R.id.backbutton);
        back = findViewById(R.id.back);
        mattyhealy = findViewById(R.id.mattyhealy);
        firststar = findViewById(R.id.firststar);
        secondstar = findViewById(R.id.secondstar);
        thirdstar = findViewById(R.id.thirdstar);
        fourthstar = findViewById(R.id.fourthstar);
        fifthstar = findViewById(R.id.fifthstar);
        mhreviews = findViewById(R.id.mhreviews);
        aboutmattyhealy = findViewById(R.id.aboutmattyhealy);
        contactdetails = findViewById(R.id.contactdetails);
        whattodonext = findViewById(R.id.whattodonext);
        email = findViewById(R.id.email);
        mhnumber = findViewById(R.id.mhnumber);
        mhemail = findViewById(R.id.mhemail);
        telephone = findViewById(R.id.telephone);
        bookanappointment = findViewById(R.id.bookanappointment);
        chat = findViewById(R.id.chat);
        videocall = findViewById(R.id.videocall);
        chaticon = findViewById(R.id.chaticon);
        videocallicon = findViewById(R.id.videocallicon);
        book = findViewById(R.id.book);
    }

    private void setListeners() {
        backbutton.setOnClickListener(view -> finish());
        back.setOnClickListener(view -> finish());
        studybuddylogo.setOnClickListener(view -> startActivity(new Intent(MattyHealy.this, Homepage.class)));

        mhnumber.setOnClickListener(view -> {
            String phoneNumber = getString(R.string.mhnumber);
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + phoneNumber));
            startActivity(callIntent);
        });

        mhemail.setOnClickListener(view -> {
            String emailAddress = getString(R.string.mhemail);
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("message/rfc822");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAddress});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");

            try {
                startActivity(Intent.createChooser(emailIntent, "Send email using"));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(MattyHealy.this, "No email clients installed.", Toast.LENGTH_SHORT).show();
            }
        });

        chat.setOnClickListener(view -> {
            Intent chatIntent = new Intent(Intent.ACTION_SEND);
            chatIntent.setType("text/plain");
            startActivity(Intent.createChooser(chatIntent, "Choose an app to chat"));
        });

        videocall.setOnClickListener(view -> {
            Intent videoCallIntent = getPackageManager().getLaunchIntentForPackage("com.microsoft.teams");
            if (videoCallIntent != null) {
                startActivity(videoCallIntent);
            } else {
                Intent chooserIntent = new Intent(Intent.ACTION_SEND);
                chooserIntent.setType("text/plain");
                startActivity(Intent.createChooser(chooserIntent, "Microsoft Teams not installed. Choose an app for video call"));
            }
        });

        View.OnClickListener bookAppointmentListener = view -> {
            Intent intent = new Intent(MattyHealy.this, BookAppointment.class);
            startActivity(intent);
        };

        bookanappointment.setOnClickListener(bookAppointmentListener);
        book.setOnClickListener(bookAppointmentListener);
    }
}
package com.ballesterosgravidezprado.studybuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.net.Uri;

public class ShinRyujin extends Activity {

    private ImageView studybuddylogo, backbutton, firststar, secondstar, thirdstar, fourthstar, fifthstar, shinryujinimage, email, telephone, chaticon, videocallicon, book;
    private TextView back, shinryujin, srreviews, aboutshinryujin, srcontactdetails, whattodonext, srnumber, sremail, bookanappointment, chat, videocall;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shinryujin);
        initializeViews();
        setListeners();
    }

    private void initializeViews() {
        studybuddylogo = findViewById(R.id.studybuddylogo);
        backbutton = findViewById(R.id.backbutton);
        back = findViewById(R.id.back);
        shinryujin = findViewById(R.id.shinryujin);
        firststar = findViewById(R.id.firststar);
        secondstar = findViewById(R.id.secondstar);
        thirdstar = findViewById(R.id.thirdstar);
        fourthstar = findViewById(R.id.fourthstar);
        fifthstar = findViewById(R.id.fifthstar);
        srreviews = findViewById(R.id.srreviews);
        aboutshinryujin = findViewById(R.id.aboutshinryujin);
        shinryujinimage = findViewById(R.id.shinryujinimage);
        srcontactdetails = findViewById(R.id.contactdetails);
        whattodonext = findViewById(R.id.whattodonext);
        email = findViewById(R.id.email);
        srnumber = findViewById(R.id.srnumber);
        sremail = findViewById(R.id.sremail);
        telephone = findViewById(R.id.telephone);
        bookanappointment = findViewById(R.id.bookanappointment);
        chat = findViewById(R.id.chat);
        videocall = findViewById(R.id.videocall);
        chaticon = findViewById(R.id.chaticon);
        videocallicon = findViewById(R.id.videocallicon);
        book = findViewById(R.id.book);
    }

    private void setListeners() {
        studybuddylogo.setOnClickListener(view -> startActivity(new Intent(ShinRyujin.this, Homepage.class)));
        backbutton.setOnClickListener(view -> finish());
        back.setOnClickListener(view -> finish());

        srnumber.setOnClickListener(view -> {
            String phoneNumber = getString(R.string.srnumber);
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + phoneNumber));
            startActivity(callIntent);
        });

        sremail.setOnClickListener(view -> {
            String emailAddress = getString(R.string.sremail);
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("message/rfc822");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAddress});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");

            try {
                startActivity(Intent.createChooser(emailIntent, "Send email using"));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(ShinRyujin.this, "No email clients installed.", Toast.LENGTH_SHORT).show();
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
            Intent intent = new Intent(ShinRyujin.this, BookAppointment.class);
            startActivity(intent);
        };

        bookanappointment.setOnClickListener(bookAppointmentListener);
        book.setOnClickListener(bookAppointmentListener);
    }
}
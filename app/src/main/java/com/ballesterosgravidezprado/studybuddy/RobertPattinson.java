package com.ballesterosgravidezprado.studybuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.net.Uri;

public class RobertPattinson extends Activity {

    private ImageView studybuddylogo, robertpattinsonimage, backbutton, firststar, secondstar, thirdstar, fourthstar, fifthstar, email, telephone, chaticon, videocallicon, book;
    private TextView back, robertpattinson, rpreviews, aboutrobertpattinson, contactdetails, whattodonext, rpnumber, rpemail, bookanappointment, chat, videocall;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.robertpattinson);
        initializeViews();
        setListeners();
    }

    private void initializeViews() {
        studybuddylogo = findViewById(R.id.studybuddylogo);
        robertpattinsonimage = findViewById(R.id.robertpattinsonimage);
        backbutton = findViewById(R.id.backbutton);
        back = findViewById(R.id.back);
        robertpattinson = findViewById(R.id.robertpattinson);
        firststar = findViewById(R.id.firststar);
        secondstar = findViewById(R.id.secondstar);
        thirdstar = findViewById(R.id.thirdstar);
        fourthstar = findViewById(R.id.fourthstar);
        fifthstar = findViewById(R.id.fifthstar);
        rpreviews = findViewById(R.id.rpreviews);
        aboutrobertpattinson = findViewById(R.id.aboutrobertpattinson);
        contactdetails = findViewById(R.id.contactdetails);
        whattodonext = findViewById(R.id.whattodonext);
        email = findViewById(R.id.email);
        rpnumber = findViewById(R.id.rpnumber);
        rpemail = findViewById(R.id.rpemail);
        telephone = findViewById(R.id.telephone);
        bookanappointment = findViewById(R.id.bookanappointment);
        chat = findViewById(R.id.chat);
        videocall = findViewById(R.id.videocall);
        chaticon = findViewById(R.id.chaticon);
        videocallicon = findViewById(R.id.videocallicon);
        book = findViewById(R.id.book);
    }

    private void setListeners() {
        studybuddylogo.setOnClickListener(view -> startActivity(new Intent(RobertPattinson.this, Homepage.class)));
        backbutton.setOnClickListener(view -> finish());
        back.setOnClickListener(view -> finish());

        rpnumber.setOnClickListener(view -> {
            String phoneNumber = getString(R.string.rpnumber);
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + phoneNumber));
            startActivity(callIntent);
        });

        rpemail.setOnClickListener(view -> {
            String emailAddress = getString(R.string.rpemail);
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("message/rfc822");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAddress});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");

            try {
                startActivity(Intent.createChooser(emailIntent, "Send email using"));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(RobertPattinson.this, "No email clients installed.", Toast.LENGTH_SHORT).show();
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
            Intent intent = new Intent(RobertPattinson.this, BookAppointment.class);
            startActivity(intent);
        };

        bookanappointment.setOnClickListener(bookAppointmentListener);
        book.setOnClickListener(bookAppointmentListener);
    }
}
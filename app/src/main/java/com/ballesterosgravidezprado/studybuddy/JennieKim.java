package com.ballesterosgravidezprado.studybuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.net.Uri;
import android.view.View;

public class JennieKim extends Activity {

    private ImageView studybuddylogo, backbutton, firststar, secondstar, thirdstar, fourthstar, fifthstar, jenniekimimage, email, telephone, chatimage, videocallimage, book;
    private TextView back, jenniekim, jkreviews, aboutjenniekim, jkcontactdetails, whattodonext, jknumber, jkemail, bookanappointment, chat, videocall;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jenniekim);
        initializeViews();
        setListeners();
    }

    private void initializeViews() {
        studybuddylogo = findViewById(R.id.studybuddylogo);
        backbutton = findViewById(R.id.backbutton);
        back = findViewById(R.id.back);
        jenniekim = findViewById(R.id.jenniekim);
        firststar = findViewById(R.id.firststar);
        secondstar = findViewById(R.id.secondstar);
        thirdstar = findViewById(R.id.thirdstar);
        fourthstar = findViewById(R.id.fourthstar);
        fifthstar = findViewById(R.id.fifthstar);
        jkreviews = findViewById(R.id.jkreviews);
        aboutjenniekim = findViewById(R.id.aboutjenniekim);
        jenniekimimage = findViewById(R.id.jenniekimimage);
        jkcontactdetails = findViewById(R.id.contactdetails);
        whattodonext = findViewById(R.id.whattodonext);
        email = findViewById(R.id.email);
        jknumber = findViewById(R.id.jknumber);
        jkemail = findViewById(R.id.jkemail);
        telephone = findViewById(R.id.telephone);
        bookanappointment = findViewById(R.id.bookanappointment);
        chat = findViewById(R.id.chat);
        videocall = findViewById(R.id.videocall);
        chatimage = findViewById(R.id.chatimage);
        videocallimage = findViewById(R.id.videocallimage);
        book = findViewById(R.id.book);
    }

    private void setListeners() {
        backbutton.setOnClickListener(view -> finish());
        back.setOnClickListener(view -> finish());
        studybuddylogo.setOnClickListener(view -> startActivity(new Intent(JennieKim.this, Homepage.class)));

        jknumber.setOnClickListener(view -> {
            String phoneNumber = getString(R.string.jknumber);
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + phoneNumber));
            startActivity(callIntent);
        });

        jkemail.setOnClickListener(view -> {
            String emailAddress = getString(R.string.jkemail);
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("message/rfc822");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAddress});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");

            try {
                startActivity(Intent.createChooser(emailIntent, "Send email using"));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(JennieKim.this, "No email clients installed.", Toast.LENGTH_SHORT).show();
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
            Intent intent = new Intent(JennieKim.this, BookAppointment.class);
            startActivity(intent);
        };

        bookanappointment.setOnClickListener(bookAppointmentListener);
        book.setOnClickListener(bookAppointmentListener);
    }
}
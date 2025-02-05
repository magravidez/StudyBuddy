package com.ballesterosgravidezprado.studybuddy;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class BookAppointment extends AppCompatActivity {

    private TextView selectDateButton;
    private TextView selectTimeButton;
    private TextView confirmAppointmentButton;
    private RelativeLayout backButton;
    private String selectedDate;
    private String selectedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookappointment);

        selectDateButton = findViewById(R.id.select_date_button);
        selectTimeButton = findViewById(R.id.select_time_button);
        confirmAppointmentButton = findViewById(R.id.confirm_appointment_button);
        backButton = findViewById(R.id.backbuttonrl);

        selectDateButton.setOnClickListener(view -> showDatePicker());
        selectTimeButton.setOnClickListener(view -> showTimePicker());

        confirmAppointmentButton.setOnClickListener(view -> {
            if (selectedDate != null && selectedTime != null) {
                Toast.makeText(this, "Appointment confirmed for " + selectedDate + " at " + selectedTime, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Please book an appointment first.", Toast.LENGTH_SHORT).show();
            }
        });

        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(BookAppointment.this, ListOfProfessionals.class);
            startActivity(intent);
            finish();
        });
    }

    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year, month, dayOfMonth) -> {
                    selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                    selectDateButton.setText(selectedDate);
                    Log.d("BookAppointment", "Date selected: " + selectedDate);
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    private void showTimePicker() {
        Calendar calendar = Calendar.getInstance();
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (view, hourOfDay, minute) -> {
                    selectedTime = hourOfDay + ":" + (minute < 10 ? "0" + minute : minute);
                    selectTimeButton.setText(selectedTime);
                    Log.d("BookAppointment", "Time selected: " + selectedTime);
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
        timePickerDialog.show();
    }
}
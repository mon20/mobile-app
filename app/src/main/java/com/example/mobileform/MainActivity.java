package com.example.mobileform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    private Button mDatePickerBtn;

    private TextInputEditText selectedDate;

    private String fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDatePickerBtn = findViewById(R.id.date_picker_btn);

    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.clear();

    long today = MaterialDatePicker.todayInUtcMilliseconds();

        calendar.setTimeInMillis(today);



    //CalendarConstraints
   // CalendarConstraints.Builder constraintBuilder = new CalendarConstraints.Builder();
     //   constraintBuilder.setValidator(new DateValidatorWeekdays());

    //MaterialDatePicker
    MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();

        builder.setSelection(today);
      //  builder.setCalendarConstraints(constraintBuilder.build());
    final MaterialDatePicker materialDatePicker = builder.build();

        mDatePickerBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");
        }
    });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener <Long>() {
            @Override
            public void onPositiveButtonClick(Long selection) {
                Calendar utc = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                utc.setTimeInMillis(selection);
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                String formatted = format.format(utc.getTime());
                selectedDate.setText(formatted);
            }
        });
    }
}
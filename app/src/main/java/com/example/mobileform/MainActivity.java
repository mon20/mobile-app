package com.example.mobileform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    private Button mDatePickerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDatePickerBtn = findViewById(R.id.date_picker_btn);

    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.clear();

    long today = MaterialDatePicker.todayInUtcMilliseconds();

        calendar.setTimeInMillis(today);

        calendar.set(Calendar.MONTH, Calendar.JANUARY);
    long january = calendar.getTimeInMillis();

        calendar.set(Calendar.MONTH, Calendar.MARCH);
    long march = calendar.getTimeInMillis();

        calendar.set(Calendar.MONTH, Calendar.DECEMBER);
    long december = calendar.getTimeInMillis();

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
    }
}
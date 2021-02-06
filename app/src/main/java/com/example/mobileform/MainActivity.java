package com.example.mobileform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

    private Button btnNext;

    private TextInputEditText selectedDate;

    private TextInputEditText nombre ,telefono ,email ,descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDatePickerBtn = findViewById(R.id.date_picker_btn);
        selectedDate = (TextInputEditText) findViewById(R.id.editTextNameDate);
        btnNext = (Button) findViewById(R.id.next_btn);

        nombre = (TextInputEditText) findViewById(R.id.editTextName);
        telefono = (TextInputEditText) findViewById(R.id.editTextNamePhone);
        email = (TextInputEditText) findViewById(R.id.editTextNameEmail);
        descripcion = (TextInputEditText) findViewById(R.id.editTextNameDescription);


    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.clear();

    long today = MaterialDatePicker.todayInUtcMilliseconds();

        calendar.setTimeInMillis(today);

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
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                String formatted = format.format(utc.getTime());
                selectedDate.setText(formatted);
            }
        });

        Intent intent = new Intent(this, DetailForm.class);
        btnNext.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                intent.putExtra(getResources().getString(R.string.paramName), nombre.getText().toString() );
                intent.putExtra(getResources().getString(R.string.paramDate), selectedDate.getText().toString() );
                intent.putExtra(getResources().getString(R.string.paramEmail), email.getText().toString() );
                intent.putExtra(getResources().getString(R.string.paramPhone), telefono.getText().toString() );
                intent.putExtra(getResources().getString(R.string.paramDescription), descripcion.getText().toString() );
                startActivity(intent);
            }
        });


    }
}
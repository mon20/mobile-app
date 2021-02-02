package com.example.mobileform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_form);
        Bundle parameters = getIntent().getExtras();

        String nombre = parameters.getString(getResources().getString(R.string.paramName));
        String date = parameters.getString(getResources().getString(R.string.paramDate));
        String email = parameters.getString(getResources().getString(R.string.paramDate));
        String phone =   parameters.getString(getResources().getString(R.string.paramEmail));
        String descripcion = parameters.getString(getResources().getString(R.string.paramDescription));

        TextView tvNombre = (TextView) findViewById(R.id.textViewName);
        TextView tvDate = (TextView) findViewById(R.id.textViewDate);
        TextView tvEmail = (TextView) findViewById(R.id.textViewEmail);
        TextView tvPhone = (TextView) findViewById(R.id.textViewPhone);
        TextView tvDescription = (TextView) findViewById(R.id.textViewDescripcion);

        tvNombre.setText(nombre);
        tvDate.setText(date);
        tvEmail.setText(email);
        tvPhone.setText(phone);
        tvDescription.setText(descripcion);
    }
}
package com.example.mobileform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailForm extends AppCompatActivity {
    Button btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_form);
        Bundle parameters = getIntent().getExtras();

        String nombre = parameters.getString(getResources().getString(R.string.paramName));
        String date = parameters.getString(getResources().getString(R.string.paramDate));
        String email = parameters.getString(getResources().getString(R.string.paramDate));
        String phone = parameters.getString(getResources().getString(R.string.paramEmail));
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

        btnEdit.findViewById(R.id.edit_btn);
        Intent intent = new Intent(this, MainActivity.class);
        btnEdit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            /*intent.putExtra(getResources().getString(R.string.paramName), nombre.getText().toString() );
            intent.putExtra(getResources().getString(R.string.paramDate), selectedDate.getText().toString() );
            intent.putExtra(getResources().getString(R.string.paramDate), email.getText().toString() );
            intent.putExtra(getResources().getString(R.string.paramPhone), telefono.getText().toString() );
            intent.putExtra(getResources().getString(R.string.paramDescription), descripcion.getText().toString() );*/
                startActivity(intent);
            }
        });
    }
}
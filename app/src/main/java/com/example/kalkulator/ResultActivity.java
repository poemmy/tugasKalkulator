package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;



public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultTextView = findViewById(R.id.resultTextView);
        TextView nimTextView = findViewById(R.id.nimTextView);
        TextView nameTextView = findViewById(R.id.nameTextView);

        double result = getIntent().getDoubleExtra("result", 0);

        resultTextView.setText("Hasil: " + result);
        nimTextView.setText("NIM: 225150407111044");
        nameTextView.setText("Nama: Nurlita Azizah");
    }
}

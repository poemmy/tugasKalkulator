package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.kalkulator.R;

public class MainActivity extends AppCompatActivity {

    EditText inputNumber1, inputNumber2;
    RadioGroup radioGroup;
    Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber1 = findViewById(R.id.inputNumber1);
        inputNumber2 = findViewById(R.id.inputNumber2);
        radioGroup = findViewById(R.id.radioGroup);
        buttonCalculate = findViewById(R.id.buttonCalculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number1Str = inputNumber1.getText().toString();
                String number2Str = inputNumber2.getText().toString();

                if (number1Str.isEmpty() || number2Str.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Masukkan kedua angka!", Toast.LENGTH_SHORT).show();
                    return;
                }

                double number1 = Double.parseDouble(number1Str);
                double number2 = Double.parseDouble(number2Str);
                double result = 0;
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    Toast.makeText(MainActivity.this, "Pilih operator!", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton selectedRadioButton = findViewById(selectedId);
                String operation = selectedRadioButton.getText().toString();

                switch (operation) {
                    case "+":
                        result = number1 + number2;
                        break;
                    case "-":
                        result = number1 - number2;
                        break;
                    case "*":
                        result = number1 * number2;
                        break;
                    case "/":
                        if (number2 != 0) {
                            result = number1 / number2;
                        } else {
                            Toast.makeText(MainActivity.this, "Tidak dapat membagi dengan nol!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        break;
                }

                Intent intent = new Intent(MainActivity.this, com.example.kalkulator.ResultActivity.class);
                intent.putExtra("result", result);
                startActivity(intent);
            }
        });
    }
}

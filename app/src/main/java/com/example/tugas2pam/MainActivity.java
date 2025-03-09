package com.example.tugas2pam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNum1, editTextNum2;
    private RadioGroup radioGroup;
    private Button buttonHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextNum1 = findViewById(R.id.editTextNum1);
        editTextNum2 = findViewById(R.id.editTextNum2);
        radioGroup = findViewById(R.id.radioGroup);
        buttonHitung = findViewById(R.id.buttonHitung);

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    private void calculate() {
        String num1Str = editTextNum1.getText().toString();
        String num2Str = editTextNum2.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = 0;

        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId == R.id.radioTambah) {
            result = num1 + num2;
        } else if (selectedId == R.id.radioKurang) {
            result = num1 - num2;
        } else if (selectedId == R.id.radioKali) {
            result = num1 * num2;
        } else if (selectedId == R.id.radioBagi) {
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                return;
            }
        }

        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("result", result);
        intent.putExtra("nim", "235150700111036");
        intent.putExtra("nama", "Dimas Rezananda");
        startActivity(intent);
    }
}

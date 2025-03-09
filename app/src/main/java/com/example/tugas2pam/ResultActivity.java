package com.example.tugas2pam;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textViewResult = findViewById(R.id.textViewResult);
        TextView textViewNim = findViewById(R.id.textViewNim);
        TextView textViewNama = findViewById(R.id.textViewNama);

        double result = getIntent().getDoubleExtra("result", 0);
        String nim = getIntent().getStringExtra("nim");
        String nama = getIntent().getStringExtra("nama");

        textViewResult.setText("Hasil: " + result);
        textViewNim.setText("NIM: " + nim);
        textViewNama.setText("Nama: " + nama);
    }
}
package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultView = findViewById(R.id.resultView);
        Button btnBack = findViewById(R.id.btnBack);

        String result = getIntent().getStringExtra("result");
        resultView.setText(result);

        btnBack.setOnClickListener(v -> finish());
    }
}

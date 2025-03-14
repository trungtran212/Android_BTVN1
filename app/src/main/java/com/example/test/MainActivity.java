package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText inputA = findViewById(R.id.inputA);
        EditText inputB = findViewById(R.id.inputB);
        EditText inputC = findViewById(R.id.inputC);
        Button btnSolve = findViewById(R.id.btnSolve);
//        TextView result = findViewById(R.id.result);

        btnSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double a = Double.parseDouble(inputA.getText().toString());
                    double b = Double.parseDouble(inputB.getText().toString());
                    double c = Double.parseDouble(inputC.getText().toString());

                    String solution = solveQuadraticEquation(a, b, c);

                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("result", solution);
                    startActivity(intent);
                } catch (NumberFormatException e) {
                    inputA.setError("Vui lòng nhập số hợp lệ");
                    inputB.setError("Vui lòng nhập số hợp lệ");
                    inputC.setError("Vui lòng nhập số hợp lệ");
                }
            }
        });

    }

    private String solveQuadraticEquation(double a, double b, double c) {
        if (a == 0) {
            if (b == 0) {
                return (c == 0) ? "Phương trình vô số nghiệm" : "Phương trình vô nghiệm";
            } else {
                return "Nghiệm: x = " + (-c / b);
            }
        }

        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            return "Nghiệm: x1 = " + x1 + ", x2 = " + x2;
        } else if (delta == 0) {
            double x = -b / (2 * a);
            return "Nghiệm kép: x = " + x;
        } else {
            return "Phương trình vô nghiệm";
        }
    }
}
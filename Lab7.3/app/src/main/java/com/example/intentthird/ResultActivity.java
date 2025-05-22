package com.example.intentthird;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    private Button btnTotal, btnSubtract;

    private EditText editA, editB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnSubtract = findViewById(R.id.btn_subtract);
        btnTotal = findViewById(R.id.btn_total);
        editA = findViewById(R.id.edit_a);
        editB = findViewById(R.id.edit_b);

        Intent myIntent = getIntent();
        int a = myIntent.getIntExtra("a",0);
        int b = myIntent.getIntExtra("b",0);

        editA.setText(a+"");
        editB.setText(b+"");

        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum = a + b;
                myIntent.putExtra("result", sum);
                setResult(33, myIntent);
                finish();
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sub = a - b;
                myIntent.putExtra("result", sub);
                setResult(34, myIntent);
                finish();
            }
        });
    }
}
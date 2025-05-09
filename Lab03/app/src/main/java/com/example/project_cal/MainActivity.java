package com.example.project_cal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnPlus, btnMinus, btnMul, btnDiv;
    EditText editResult, editA, editB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editResult = (EditText)  findViewById(R.id.edit_result);
        editA = (EditText)  findViewById(R.id.edit_a);
        editB = (EditText) findViewById(R.id.edit_b);
        btnPlus = (Button) findViewById(R.id.btn_plus);
        btnMinus = (Button) findViewById(R.id.btn_minus);
        btnMul = (Button) findViewById(R.id.btn_mul);
        btnDiv = (Button) findViewById(R.id.btn_div);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0"+editA.getText());
                int b = Integer.parseInt("0"+editB.getText());
                editResult.setText("a + b = "+(a+b));
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0"+editA.getText());
                int b = Integer.parseInt("0"+editB.getText());
                editResult.setText("a - b = "+(a-b));
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0"+editA.getText());
                int b = Integer.parseInt("0"+editB.getText());
                editResult.setText("a * b = "+(a*b));
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0"+editA.getText());
                int b = Integer.parseInt("0"+editB.getText());

                if(b == 0) {
                    editResult.setText("b phải là 1 số khác 0");
                } else {
                    editResult.setText("a / b = "+(a/b));
                }
            }
        });
    }
}
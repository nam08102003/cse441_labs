package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editHeight, editWeight, editBMI, editDiagnosis;
    private Button btnCalculate;

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

        btnCalculate = findViewById(R.id.btn_calculate);
        editBMI = findViewById(R.id.edit_result);
        editHeight = findViewById(R.id.edit_height);
        editWeight = findViewById(R.id.edit_weight);
        editDiagnosis = findViewById(R.id.edit_diagnosis);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double height = Double.parseDouble(editHeight.getText() + "");
                double weight = Double.parseDouble(editWeight.getText() + "");
                double bmi = weight/Math.pow(height,2);
                String diagnosisText = "";

                if(bmi < 18) {
                    diagnosisText = "Bạn gầy";
                } else if (bmi <= 24.9) {
                    diagnosisText = "Bạn bình thường";
                } else if (bmi <= 29.9) {
                    diagnosisText = "Bạn béo phì cấp độ 1";
                } else if (bmi <= 34.9) {
                    diagnosisText = "Bạn béo phì cấp độ 2";
                } else {
                    diagnosisText = "Bạn béo phì cấp độ 3";
                }

                DecimalFormat dcf = new DecimalFormat("#.0");
                editBMI.setText(String.valueOf(dcf.format(bmi)));
                editDiagnosis.setText(diagnosisText);
            }
        });
    }
}
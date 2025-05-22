package com.example.intentthird;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editA, editB, editResult;
    private Button btnRequest;

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

        editA = findViewById(R.id.edit_a);
        editB = findViewById(R.id.edit_b);
        editResult = findViewById(R.id.edit_result);
        btnRequest = findViewById(R.id.btn_request);

        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);
                int a = Integer.parseInt(editA.getText() + "");
                int b = Integer.parseInt(editB.getText() + "");

                myIntent.putExtra("a", a);
                myIntent.putExtra("b", b);

                startActivityForResult(myIntent, 99);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 99 && resultCode == 33) {
            int sum = data.getIntExtra("result",0);
            editResult.setText("Tổng 2 số là: " + sum);
        }
        if(requestCode == 99 && resultCode == 34) {
            int sum = data.getIntExtra("result",0);
            editResult.setText("Hiệu 2 số là: " + sum);
        }
    }
}
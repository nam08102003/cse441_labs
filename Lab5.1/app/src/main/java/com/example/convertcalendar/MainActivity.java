package com.example.convertcalendar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private EditText editSolarYear, editLunarYear;
    private Button btnConvert;

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

        btnConvert = findViewById(R.id.btn_convert);
        editLunarYear = findViewById(R.id.edit_lunar_year);
        editSolarYear = findViewById(R.id.edit_solar_year);

        ArrayList<String> canList = new ArrayList<>(Arrays.asList(
                "Canh", "Tân", "Nhâm", "Quý", "Giáp",
                "Ất", "Bính", "Đinh", "Mậu", "Kỷ"
        ));

        ArrayList<String> chiList = new ArrayList<>(Arrays.asList(
                "Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu",
                "Dần", "Mẹo", "Thìn", "Tỵ", "Ngọ", "Mùi"
        ));



        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int solarYear = Integer.parseInt(editSolarYear.getText() + "");
                int can, chi;
                can = solarYear % 10;
                chi = solarYear % 12;

                String lunarYearText = canList.get(can) + " " + chiList.get(chi);
                editLunarYear.setText(lunarYearText);
            }
        });
    }
}
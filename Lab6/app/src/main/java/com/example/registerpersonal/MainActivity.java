package com.example.registerpersonal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editName, editCMND, editFavorite;
    Button btnSubmit;
    CheckBox checkPaper, checkBook, checkCode;
    RadioGroup groupDegree;

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

        editName = findViewById(R.id.edit_name);
        editCMND = findViewById(R.id.edit_cmnd);
        editFavorite = findViewById(R.id.edit_favorite);
        btnSubmit = findViewById(R.id.btn_submit);
        checkPaper = findViewById(R.id.check_paper);
        checkBook = findViewById(R.id.check_book);
        checkCode = findViewById(R.id.check_coding);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doShowInformation();
            }
        });
    }

    public void doShowInformation() {
        String name = editName.getText() + "";
        name = name.trim();
        if(name.length()<3)
        {
            editName.requestFocus();
            editName.selectAll();
            Toast.makeText(this, "Tên phải >= 3 ký tự", Toast.LENGTH_LONG).show();
            return;
        }
        String cmnd=editCMND.getText().toString();
        cmnd=cmnd.trim();
        if(cmnd.length()!=9)
        {
            editCMND.requestFocus();
            editCMND.selectAll();
            Toast.makeText(this, "CMND phải đúng 9 ký tự", Toast.LENGTH_LONG).show();
            return;
        }
        String degree="";
        groupDegree = findViewById(R.id.group_degree);
        int id=groupDegree.getCheckedRadioButtonId();
        if(id==-1)
        {
            Toast.makeText(this, "Phải chọn bằng cấp",
                    Toast.LENGTH_LONG).show();
            return;
        }
        RadioButton rade = findViewById(id);
        degree = rade.getText().toString();

        String sothich="";
        if(checkPaper.isChecked())
            sothich+=checkPaper.getText()+"\n";
        if(checkBook.isChecked())
            sothich+=checkBook.getText()+"\n";
        if(checkCode.isChecked())
            sothich+=checkCode.getText()+"\n";

        String bosung=editFavorite.getText().toString();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        String msg="";
        msg+= name + "\n";
        msg+= cmnd + "\n";
        msg+= degree + "\n";
        msg+= sothich + "\n";
        msg+= "Thông tin bổ sung:\n";
        msg+= bosung + "\n";

        builder.setMessage(msg);
        builder.create().show();
    }



    @Override()
    public void onBackPressed() {
        AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
        b.setTitle("Question");
        b.setMessage("Are you sure you want to exit?");
        b.setIcon(R.drawable.inform);
        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        b.create().show();
    }
}
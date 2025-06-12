package com.example.readdataxml;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnparse;
    ListView lv;
    ArrayList<String> mylist;
    ArrayAdapter<String> myadapter;


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

        btnparse = findViewById(R.id.btnparse);
        lv = findViewById(R.id.lv);

        mylist = new ArrayList<>();
        myadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mylist);
        lv.setAdapter(myadapter);

        btnparse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parsexml();
            }
        });
    }
    private void parsexml() {
        mylist.clear();
        try {
            InputStream myinput = getAssets().open("employee.xml");
            XmlPullParserFactory fc = XmlPullParserFactory.newInstance();
            XmlPullParser parser = fc.newPullParser();
            parser.setInput(myinput, null);

            int eventType = -1;
            String nodeName;
            String datashow = "";

            while (eventType != XmlPullParser.END_DOCUMENT) {
                eventType = parser.next();
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        nodeName = parser.getName();
                        if (nodeName.equals("employee")) {
                            datashow += parser.getAttributeValue(0) + "-";
                            datashow += parser.getAttributeValue(1) + "-"; 
                        } else if (nodeName.equals("name")) {
                            if(parser.next() == XmlPullParser.TEXT) {
                                datashow += parser.getText() + "-";
                            }
                        } else if (nodeName.equals("phone")) {
                            if(parser.next() == XmlPullParser.TEXT) {
                                datashow += parser.getText();
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        nodeName = parser.getName();
                        if (nodeName.equals("employee")) {
                            mylist.add(datashow);
                            datashow = "";
                        }
                        break;
                }
            }
            myadapter.notifyDataSetChanged();

        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }
}
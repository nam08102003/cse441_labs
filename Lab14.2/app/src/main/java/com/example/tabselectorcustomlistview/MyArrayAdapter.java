package com.example.tabselectorcustomlistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Item> {
    Activity context = null;
    ArrayList<Item> myArray = null;
    private int LayoutId;

    public MyArrayAdapter(Activity context, int LayoutId,ArrayList<Item>arr) {
        super(context, LayoutId,arr);
        this.context = context;
        this.LayoutId = LayoutId;
        this.myArray = arr;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(LayoutId, null);
        Item myItem = myArray.get(position);
        ImageView btnlike = convertView.findViewById(R.id.btn_like);
        int favorite = myItem.getFavorite();
        if (favorite == 1) {
            btnlike.setImageResource(R.drawable.ic_heart);
        } else {
            btnlike.setImageResource(R.drawable.ic_unheart);
        }
        TextView title = convertView.findViewById(R.id.txt_title);
        title.setText(myItem.getTitle());
        TextView code = convertView.findViewById(R.id.txt_code);
        code.setText(myItem.getCode());
        return convertView;
    }

}

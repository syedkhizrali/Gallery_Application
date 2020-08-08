package com.syedkhizrali.galleryapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.syedkhizrali.galleryapplication.R;
import com.syedkhizrali.galleryapplication.adapters.ImageAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> imageArray = new ArrayList <>(Arrays.asList(
            R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,
            R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,
            R.drawable.img9,R.drawable.img10,R.drawable.img11
    ));

    private GridView grid_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //method calls
        init();
        setAdapter();
        onClick();

        //method calls
    }

    public void showDialogBox(final int item_pos){
        final Dialog dialog = new Dialog(MainActivity.this);

        dialog.setContentView(R.layout.custom_dialog);

        //Getting custom dialog views
        TextView Image_name = dialog.findViewById(R.id.txt_Image_name);
        ImageView Image = dialog.findViewById(R.id.img);
        Button btn_Full = dialog.findViewById(R.id.btn_full);
        Button btn_Close = dialog.findViewById(R.id.btn_close);

        String title = getResources().getResourceName(item_pos);

        //extracting name
        int index = title.indexOf("/");
        String name = title.substring(index+1,title.length());
        Image_name.setText(name);

        Image.setImageResource(item_pos);

        btn_Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btn_Full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        dialog.show();

    }

    private void onClick() {
        grid_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int item_pos = imageArray.get(position);
                showDialogBox(item_pos);
            }
        });
    }

    private void setAdapter() {
        grid_view.setAdapter(new ImageAdapter(this, imageArray));
    }

    private void init() {
        grid_view = findViewById(R.id.grid_view);
    }
}